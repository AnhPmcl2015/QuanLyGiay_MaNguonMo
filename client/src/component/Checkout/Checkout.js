import './Checkout.css';
import React, { Component } from 'react';
import { Steps, Button, message, Card, Col, Row, Alert, List, Avatar, Modal } from 'antd';
import StepOne from './StepOne';
import StepTwo from './StepTwo';
import StepThree from './StepThree';
import { database } from '../../firebase';
import moment from 'moment';
import moneyUtil from '../../common/Utils/ParseMoney';
import { getShoe } from '../Cart/CartAPI';
import { getCurrentUser } from '../../common/UserAPI/UserAPI';
import LoadingIndicator from '../LoadingIndicator/LoadingIndicator';
const Step = Steps.Step;

class Checkout extends Component {
    state = {
        current: 0,
        isLoading: false,
        customer: null,
        isValid: false,
        total: 0,
        discount: 0,
        summary: 0,
        shipMethod: 'normal',
        paymentMethod: 'cod',
        paid: false,
        items: [],
    };

    handlerNext = (customer, isValid, shipMethod, paymentMethod) => {
        const { current } = this.state;
        if (current === 0) {
            if (!isValid) {
                message.error('Vui lòng điền đầy đủ thông tin');
            } else {
                this.setState({
                    customer: customer,
                    isValid: true,
                    shipMethod
                });
                this.next();
            }
            return;
        }

        if (this.state.current === 1) {
            this.setState({
                paymentMethod: paymentMethod,
            });
            this.next();
        }
    }

    pay = (e) => {
        e.preventDefault();
        const { customer, shipMethod, paymentMethod, total, discount, summary } = this.state;
        this.addNewOrder(customer, shipMethod, paymentMethod, total, discount, summary).then(function () {
            // success
            localStorage.removeItem('items');
        }).catch(function (error) {
            message.error('Thanh toán thất bại! ' + error)
        });

        this.setState({
            paid: true,
        });
    }

    addNewOrder(customer, shipMethod, paymentMethod, total, discount, summary) {
        var products = [];
        this.state.items.forEach(item => {
            const product = {
                shoeId: item.shoe.idChiTietGiay,
                shoeName: item.shoe.giay.tenGiay,
                price: item.shoe.giay.giaBan,
                amount: item.amount,
                sum: item.shoe.giay.giaBan * item.amount,
            }
            products.push(product);
        });

        // Get a key for a new order.
        var key = database.ref().child('orders').push().key;

        // A order entry.
        var order = {
            orderId: key,
            orderDate: moment().format("DD-MM-YYYY"),
            customerEmail: customer.email,
            customerName: customer.name,
            customerPhone: customer.prefix + customer.phone,
            customerAddress: customer.address,
            shipMethod: shipMethod,
            paymentMethod: paymentMethod,
            // total: total,
            // discount: discount,
            summary: summary,
            status: 'Mới nhận',
            products
        };

        // Write order
        var updates = {};
        updates['/orders/' + key] = order;

        return database.ref().update(updates);
    }

    next() {
        const summary = this.state.items.reduce(function (accumulator, currentValue) {
            return accumulator + (currentValue.amount * currentValue.shoe.giay.giaBan);
        }, 0)

        const current = this.state.current + 1;
        this.setState({ current, summary });
    }
    prev() {
        const current = this.state.current - 1;
        this.setState({ current });
    }

    delete = (id) => {
        const items = JSON.parse(localStorage.getItem('items'));
        const newItems = items.filter(function (item) {
            return item.id.toString() !== id.toString();
        });
        const _newItems = this.state.items.filter(function (item) {
            return item.shoe.giay.idGiay.toString() !== id.toString();
        });
        const summary = _newItems.reduce(function (accumulator, currentValue) {
            return accumulator + (currentValue.amount * currentValue.shoe.giay.giaBan);
        }, 0)
        this.setState({ items: _newItems, summary });
        localStorage.setItem('items', JSON.stringify(newItems));
    }

    handleRedirect = () => {
        this.props.history.push("/gio-hang");
    }

    componentWillMount() {
        const items = JSON.parse(localStorage.getItem('items'));
        if (items !== null) {
            this.setState({ isLoading: true });
            var temp = this.state.items;
            items.forEach(item => {
                getShoe(item.id)
                    .then(response => {
                        temp.push({
                            shoe: response,
                            amount: item.amount
                        });
                        this.setState({ items: temp });
                    }).catch(error => {
                        console.log(error);
                    });
            });

            this.setState({
                isLoading: false
            });
        } else {
            console.log('Cart empty!');
        }

    }

    componentDidMount() {
        getCurrentUser()
            .then(response => {
                const customer = {
                    email: response.user.email,
                    name: response.tenKhachHang,
                    phone: response.soDienThoai,
                    address: response.diaChi,
                };
                this.setState({
                    customer
                });
            })
            .catch(error => {
                console.log(error);
            });
    }

    render() {
        const { current, isLoading, shipMethod, customer, total, discount, summary, paymentMethod, paid, items } = this.state;
        const cart = JSON.parse(localStorage.getItem('items'));
        const layout = {
            paymentZone: { xs: 24, sm: 16, md: 16, lg: 16 },
            cartZone: { xs: 24, sm: 8, md: 8, lg: 8 },
        }
        const steps = [{
            title: 'Địa chỉ',
            content: <StepOne customer={customer} selectedShipMethod={shipMethod} handlerNext={this.handlerNext} />,
        }, {
            title: 'Thanh toán',
            content: <StepTwo handlerNext={this.handlerNext} />,
        }, {
            title: 'Hoàn tất',
            content: <StepThree customer={customer} summary={summary} shipMethod={shipMethod}
                paymentMethod={paymentMethod} total={total} discount={discount} />,
        }];
        const sum = this.state.items.reduce(function (accumulator, currentValue) {
            return accumulator + (currentValue.amount * currentValue.shoe.giay.giaBan);
        }, 0)

        if (isLoading) {
            return <LoadingIndicator />
        }
        return (
            <div style={{ padding: '50px' }}>
                <br />
                {cart !== null ?
                    <Row gutter={32}>
                        <Col {...layout.paymentZone}>
                            {
                                paid &&
                                <Alert
                                    message="Thanh toán thành công"
                                    description="Cảm ơn bạn đã mua sản phẩm của chúng tôi. Bạn sẽ nhận được email về thông tin chi tiết đơn hàng này"
                                    type="success"
                                    showIcon
                                />
                            }
                            <Card title="Thanh toán đơn hàng" className="w-100 p-3"
                                headStyle={{ background: 'black', color: 'white', margin: '-15px' }} bordered={true} >
                                <Steps current={current}>
                                    {steps.map(item => <Step key={item.title} title={item.title} />)}
                                </Steps>
                                <br />
                                <div className="steps-content">
                                    {steps[current].content}
                                </div>
                                <div className="steps-action">
                                    {
                                        current > 0
                                        &&
                                        (
                                            <Button disabled={paid} onClick={() => this.prev()}>
                                                Quay lại
                                        </Button>
                                        )
                                    }
                                    {
                                        current === steps.length - 1
                                        && <Button className="float-right" type="primary" disabled={paid} onClick={this.pay}>Thanh toán</Button>
                                    }
                                </div>
                            </Card>
                        </Col>

                        <Col {...layout.cartZone}>
                            <Card title="Các sản phẩm đã thêm vào giỏ hàng" className="w-100 p-3"
                                headStyle={{ background: 'black', color: 'white', margin: '-15px' }}>
                                <List
                                    itemLayout="vertical"
                                    size="large"
                                    locale={{ emptyText: "Giỏ hàng trống" }}
                                    dataSource={items}
                                    footer={<h5 className="float-right">Tổng cộng: {moneyUtil.format(sum)}</h5>}
                                    renderItem={item => (
                                        <List.Item
                                            key={item.shoe.idChiTietGiay}
                                            extra={<div><h5>{moneyUtil.format(item.shoe.giay.giaBan * item.amount)}</h5>
                                                <Button disabled={paid} onClick={() => this.delete(item.shoe.idChiTietGiay)} className="float-right" icon="delete" type="danger"></Button></div>}>
                                            <List.Item.Meta
                                                avatar={<Avatar src={item.shoe.giay.img1} shape="square" size={100} />}
                                                title={<div>{item.shoe.giay.tenGiay} (#{item.shoe.idChiTietGiay})
                                            </div>}
                                                description={<div>
                                                    {item.shoe.giay.loaiGiay.tenLoaiGiay} <br />
                                                    <b>Đơn giá: {moneyUtil.format(item.shoe.giay.giaBan)}</b><br />
                                                    <b>Số lượng: {item.amount}</b></div>}
                                            />
                                        </List.Item>
                                    )} />
                            </Card>
                            <br />
                        </Col>
                    </Row>
                    :
                    <Modal
                        title="Thông báo"
                        centered
                        visible={true}
                        onCancel={this.handleRedirect}
                        footer={[
                            <Button key="back" onClick={this.handleRedirect}>Quay lại</Button>,
                        ]}
                    >
                        <h4>Giỏ hàng của bạn đang trống !</h4>
                        <h5>Vui lòng bấm quay lại để chọn sản phẩm trước khi thanh toán</h5>
                    </Modal>
                }
            </div>
        );
    }
}

export default Checkout;