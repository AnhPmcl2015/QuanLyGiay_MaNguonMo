import React, { Component } from 'react';
import { Link } from 'react-router-dom'
import { Card, Row, Col, Alert, Modal, Button, Skeleton, List, Avatar, Input } from 'antd';
import { UncontrolledAlert } from 'reactstrap';
import { getShoe } from './CartAPI';
import { getCurrentUser } from '../../common/UserAPI/UserAPI';
import moneyUtil from '../../common/Utils/ParseMoney';


class Cart extends Component {
    state = {
        isLogged: false,
        isLoading: false,
        visiblePromotion: false,
        items: [],
    }

    showModal = () => {
        this.setState({
            visiblePromotion: true,
        });
    }

    handleCancel = () => {
        this.setState({ visiblePromotion: false });
    }

    delete = (id) => {
        const items = JSON.parse(localStorage.getItem('items'));
        const newItems = items.filter(function (item) {
            return item.id.toString() !== id.toString();
        });
        const _newItems = this.state.items.filter(function (item) {
            return item.shoe.giay.idGiay.toString() !== id.toString();
        });
        this.setState({ items: _newItems });
        localStorage.setItem('items', JSON.stringify(newItems));
    }

    addToCart(id, amount) {
        //localStorage.clear();
        const item = {
            id: id,
            amount: amount
        }

        var cart = JSON.parse(localStorage.getItem('items'));
        var items = [];
        if (cart === null) {
            items.push(item);
            localStorage.setItem('items', JSON.stringify(items));
            console.log('Thêm sp đầu tiên với mã #' + item.id);
            console.log(JSON.parse(localStorage.getItem('items')));
            return;
        } else {
            for (var i = 0; i < cart.length; i++) {
                if (cart[i].id === id) {
                    var temp = cart;
                    temp[i].amount += amount;
                    localStorage.setItem('items', JSON.stringify(temp));
                    console.log('Cộng dồn số lượng sp #' + item.id);
                    console.log(JSON.parse(localStorage.getItem('items')));
                    return;
                }
            }

            cart.push(item);
            localStorage.setItem('items', JSON.stringify(cart));
            console.log('Thêm sản phẩm mới với mã #' + item.id);
            console.log(JSON.parse(localStorage.getItem('items')));
        }
    }

    userCheckout = () => {
        const isLogged = this.state.isLogged;
        if (isLogged)
            this.props.history.push("/thanh-toan");
        else
            this.props.history.push("/login");
    }

    guestCheckout = () => {

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

        getCurrentUser()
            .then(response => {
                // this.props.history.push({
                //     pathname: '/thanh-toan',
                //     state: { loggedCustomer: response }
                //   })
                this.setState({ isLogged: true });
            }).catch(error => {
                this.setState({ isLogged: false });
            });
    }

    render() {
        const layout = {
            cartZone: {
                xs: 24,
                sm: {
                    span: 12,
                    offset: 3
                }, md: {
                    span: 12,
                    offset: 3
                }, lg: {
                    span: 12,
                    offset: 3
                }
            },
            summaryZone: { xs: 24, sm: 4, md: 4, lg: 6 },
        }
        const { visiblePromotion, isLoading, isLogged, items } = this.state;
        const sum = items.reduce(function (accumulator, currentValue) {
            return accumulator + (currentValue.amount * currentValue.shoe.giay.giaBan);
        }, 0)
        return (
            <div>
                <Button onClick={() => this.addToCart(1, 1)}>add to cart sp1</Button>
                <Button onClick={() => this.addToCart(2, 1)}>add to cart sp2</Button>
                <Button onClick={() => localStorage.clear()}>clear cart</Button>
                <Row gutter={50}>
                    <Col {...layout.cartZone}>
                        <Alert
                            message="Miễn phí giao hàng với thành viên"
                            description={
                                <div>
                                    Đăng kí thành viên với chúng tôi để nhận nhiều ưu đãi và thông tin khuyến mãi hơn.&nbsp;
                                    <Link to="/dang-ky">Đăng ký</Link> &nbsp;hoặc&nbsp;
                                    <Link to="/dang-nhap">Đăng nhập</Link>
                                </div>
                            }
                            type="info"
                            showIcon
                        /><br />
                        <UncontrolledAlert color="dark">
                            <b>Miễn phí giao hàng nhanh</b><br />
                            Đối với những đơn hàng với tổng trị giá trên 2.000.000đ, khách hàng được miễn phí giao hàng nhanh.&nbsp;
                            <Link to="#" onClick={this.showModal}>Xem chi tiết</Link>
                        </UncontrolledAlert>
                        <Modal
                            visible={visiblePromotion}
                            title="Thông tin khuyến mãi"
                            onCancel={this.handleCancel}
                            footer={[
                                <Button key="back" onClick={this.handleCancel}>Đóng</Button>,
                            ]}
                        >
                            <p>Nội khuyến mãi...</p>
                            <Skeleton active />
                        </Modal>
                    </Col>
                    <Col {...layout.summaryZone}>
                        <Card title="Mã giảm giá" className="w-100 p-3"
                            headStyle={{ background: 'black', color: 'white', margin: '-15px' }}>
                            <Input placeholder="Nhập mã giảm giá..." />
                            <br /><br />
                            <Button size='large' type="primary" block>Áp dụng</Button>
                        </Card>
                    </Col>
                </Row><br />
                <Row gutter={50}>
                    <Col {...layout.cartZone}>
                        <Skeleton active loading={isLoading} >
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
                                                <Button onClick={() => this.delete(item.shoe.idChiTietGiay)} className="float-right" icon="delete" type="danger"></Button></div>}>
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
                        </Skeleton>
                    </Col>
                    <Col {...layout.summaryZone}>
                        <Card title="Tổng cộng" className="w-100 p-3"
                            headStyle={{ background: 'black', color: 'white', margin: '-15px' }}>
                            <Row>
                                <Col span={12}><b>Tổng:</b></Col>
                                <Col span={12}><b className="float-right">{moneyUtil.format(sum)}</b></Col>
                            </Row>
                            <Row>
                                <Col span={12}><b>Vận chuyển:</b></Col>
                                <Col span={12}><b className="float-right">Miễn phí</b></Col>
                            </Row>
                            <Row>
                                <Col span={12}><b>Giảm giá:</b></Col>
                                <Col span={12}><b className="float-right">0%</b></Col>
                            </Row>
                            <Row>
                                <Col span={12}><b>Thành tiền:</b></Col>
                                <Col span={12}><b className="float-right">{moneyUtil.format(sum)}</b></Col>
                            </Row>
                            <br /><br />
                            <Button onClick={this.userCheckout} disabled={items.length === 0} icon="user" size='large' type="primary" block>THÀNH VIÊN THANH TOÁN</Button> <br /><br />
                            <Button onClick={this.guestCheckout} disabled={items.length === 0 || isLogged} icon="poweroff" size='large' type="danger" block>KHÁCH THANH TOÁN</Button>
                        </Card>
                    </Col>
                </Row>
            </div >
        );
    }
}

export default Cart;