import { Table, Badge } from 'antd';
import React, { Component } from 'react';

class Order extends Component {
    render() {
        return (
            <div >
                <NestedTable />
            </div>
        );
    }
}

function NestedTable() {
    const expandedRowRender = () => {
        const columns = [
            { title: 'Mã sản phẩm', dataIndex: 'productId', key: 'productId' },
            { title: 'Tên sản phẩm', dataIndex: 'productName', key: 'productName' },
            { title: 'Đơn giá', dataIndex: 'productPrice', key: 'productPrice' },
            { title: 'Số lượng', dataIndex: 'amount', key: 'amount' },
            { title: 'Thành tiền', dataIndex: 'total', key: 'total' },
        ];

        const data = [];
        for (let i = 0; i < 2; ++i) {
            data.push({
                key: i,
                productId: '#' + i,
                productName: 'Tên sản phẩm ' + i,
                productPrice: '50000' + i,
                amount: i,
                total: 50000 * i,
            });
        }
        return (
            <Table
                columns={columns}
                dataSource={data}
                pagination={false}
            />
        );
    };

    const columns = [
        { title: 'Tên', dataIndex: 'customerName', key: 'customerName' },
        { title: 'Địa chỉ', dataIndex: 'address', key: 'address' },
        { title: 'Ngày', dataIndex: 'orderDate', key: 'orderDate' },
        { title: 'Tổng tiền', dataIndex: 'total', key: 'total' },
        { title: 'Trạng thái', dataIndex: 'status', key: 'status' },
    ];

    const data = [];
    for (let i = 0; i < 5; ++i) {
        data.push({
            key: i,
            customerName: 'customer' + i,
            address: 'HCM',
            orderDate: '2014-12-24 23:12:00',
            total: 500,
            status: 'Hoàn thành',
        });
    }

    return (
        <Table
            className="components-table-demo-nested"
            columns={columns}
            expandedRowRender={expandedRowRender}
            dataSource={data}
        />
    );
}
export default Order;
