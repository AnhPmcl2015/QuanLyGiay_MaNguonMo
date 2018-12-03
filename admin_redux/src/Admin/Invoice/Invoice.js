import './Invoice.css';
import React, { Component } from 'react';
import { Table, Modal, Button } from 'antd';
import { database } from "../../../firebase";
import { getOrderDetail } from '../../../API/Private/InvoiceAPI';


class Invoice extends Component {
    constructor(props) {
        super(props);
        this.state = {
            dataSourceOrders: null,
            dataSourceOrderDetail: null,
            isLoading: false,
            visibleDetail: false,
            selectedOrder: Object,
        };
    }

    showModal = (record) => {
        this.setState({
            visibleDetail: true,
            selectedOrder: record
        });
        this.loadOrderDetail(record.orderId);
    }

    handleOk = () => {
        this.setState({ visible: false });
    }

    handleCancel = () => {
        this.setState({ visible: false });
    }

    loadOrderDetail(orderId) {
        this.setState({
            isLoading: true
        });
        getOrderDetail(orderId)
            .then(response => {
                console.log(response);
                this.setState({
                    dataSourceOrderDetail: response,
                    isLoading: false
                });
            }).catch(error => {
                if (error.status === 404) {
                    this.setState({
                        notFound: true,
                        isLoading: false
                    });
                } else {
                    this.setState({
                        serverError: true,
                        isLoading: false
                    });
                }
            });
    }

    componentDidMount() {
        database.ref("/orders").once('value', (snapshot) => {
            var orders = [];
            snapshot.forEach(function (childSnapshot) {
                var value = childSnapshot.val();
                orders.push(value);
            })
            this.setState({
                dataSourceOrders: orders
            });
        });
    }

    render() {
        const columnsTableOrder = [
            { title: 'Mã', dataIndex: 'orderId', key: 'orderId' },
            { title: 'Ngày', dataIndex: 'orderDate', key: 'orderDate' },
            { title: 'Tên', dataIndex: 'customerName', key: 'customerName' },
            { title: 'Số điện thoại', dataIndex: 'customerPhone', key: 'customerPhone' },
            { title: 'Tổng tiền', dataIndex: 'summary', key: 'summary' },
            { title: 'Tình trạng', dataIndex: 'status', key: 'status' },
            {
                title: '', dataIndex: 'x', key: '',
                render: (text, record) =>
                    <a onClick={() => this.showModal(record)} >
                        Xem chi tiết
                    </a>
            }
        ];
        const columnsTableOrderDetail = [
            { title: 'Mã sản phẩm', dataIndex: 'chiTietGiay.giay.idGiay', key: 'chiTietGiay.giay.idGiay' },
            { title: 'Tên sản phẩm', dataIndex: 'chiTietGiay.giay.tenGiay', key: 'chiTietGiay.giay.tenGiay' },
            { title: 'Đơn giá', dataIndex: 'chiTietGiay.giay.giaBan', key: 'chiTietGiay.giay.giaBan' },
            { title: 'Số lượng', dataIndex: 'soLuong', key: 'soLuong' },
            { title: 'Thành tiền', dataIndex: 'thanhTien', key: 'thanhTien' },
        ];
        const selectedOrder = this.state.selectedOrder
        return (
            <div>
                <Table
                    columns={columnsTableOrder}
                    rowKey='orderId'
                    dataSource={this.state.dataSourceOrders}
                />
                <Modal
                    title={'Thông tin đơn hàng #' + selectedOrder.orderId}
                    width={1000}
                    visible={this.state.visibleDetail}
                    onOk={this.handleOk}
                    onCancel={this.handleCancel}
                    footer={[
                        <Button key="submit" type="primary" onClick={this.handleOk}>
                            Đóng
                        </Button>,
                    ]}
                >
                    <table>
                        <tbody>
                            <tr>
                                <td>Tên khách hàng:</td>
                                <td>{selectedOrder.customerName}</td>
                            </tr>
                            <tr>
                                <td>Ngày mua:</td>
                                <td>{selectedOrder.orderDate}</td>
                            </tr>
                            <tr>
                                <td>Số điện thoại:</td>
                                <td>{selectedOrder.customerPhone}</td>
                            </tr>
                            <tr>
                                <td>Trạng thái:</td>
                                <td>{selectedOrder.status}</td>
                            </tr>
                        </tbody>
                    </table>
                    <br />
                    <Table rowKey='idChiTietDonHang' dataSource={this.state.dataSourceOrderDetail} columns={columnsTableOrderDetail} />
                </Modal>
            </div>
        );
    }
}

export default Invoice;