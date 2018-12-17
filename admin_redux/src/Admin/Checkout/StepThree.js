import './Checkout.css';
import React, { Component } from 'react';
import { Row, Col, Divider, Icon } from 'antd';

class StepThree extends Component {
    state = {
        email: 'dieu556@gmail.com',
        name: 'Nguyễn Tấn Diệu',
        phone: '0822970000',
        address: 'Gò Vấp, HCM',
        paymentMethod: 'cod',
        shipMethod: 'Tiêu chuẩn',
        sum: 0,
        discount: 0,
        total: 0,
    }


    render() {
        const { email, name, phone, address, shipMethod, paymentMethod, sum, discount, total } = this.state;
        return (
            <div>
                <Row>
                    <Col span={8}>
                        <b>Thông tin người mua: </b>
                        <br /> <br />
                        <p>{email}</p>
                        <p>{name}</p>
                        <p>{phone}</p>
                        <p>{address}</p>
                    </Col>
                    <Col span={8}>
                        <b>Phương thức thanh toán: </b> <br /> <br />
                        <Icon type="dollar" theme="twoTone" />
                        {paymentMethod === 'cod' && 'Thanh toán khi nhận hàng.'}<br /><br />
                        <b>Chế độ giao hàng: </b> <br /><br />
                        <Icon type="car" theme="twoTone" /> {shipMethod}
                    </Col>
                    <Col span={8}>
                        <b>Chi tiết mua hàng </b><br /> <br />
                        <Row>
                            <Col span={12}>Tổng cộng:</Col>
                            <Col span={12}>{sum}</Col>
                        </Row>
                        <Row>
                            <Col span={12}>Giảm giá:</Col>
                            <Col span={12}>{discount}</Col>
                        </Row>
                        <Divider/>
                        <Row>
                            <Col span={12}>Thành tiền:</Col>
                            <Col span={12}>{total}</Col>
                        </Row>
                    </Col>
                </Row>
                <br />
            </div >
        );
    }
}

export default StepThree;
