import './Checkout.css';
import React, { Component } from 'react';
import { Steps, Button, message, Card, Radio, Divider, Col, Row } from 'antd';
import StepOne from './StepOne';
import StepTwo from './StepTwo';
import StepThree from './StepThree';

const Step = Steps.Step;

class Checkout extends Component {
    state = {
        current: 0,
        shipMethod: 'normal',

        test : 'test parent'
    };

    handler = () => {
        console.log('click parent');
    }

    onChangeShipMethod = (e) => {
        console.log('ship method: ', e.target.value);
        this.setState({
            shipMethod: e.target.value,
        });
    }

    next() {
        const current = this.state.current + 1;
        this.setState({ current });
    }
    prev() {
        const current = this.state.current - 1;
        this.setState({ current });
    }

    render() {
        const steps = [{
            title: 'Địa chỉ',
            content: <StepOne test={this.state.test} handler={this.handler} />,
        }, {
            title: 'Thanh toán',
            content: <StepTwo />,
        }, {
            title: 'Hoàn tất',
            content: <StepThree />,
        }];

        const { current, shipMethod } = this.state;
        return (
            <div style={{ padding: '50px' }}>
                {this.state.test}
                <Row>
                    <Col span={16}>
                        <Card title="Thanh toán đơn hàng" bordered={true} >
                            <Steps current={current}>
                                {steps.map(item => <Step key={item.title} title={item.title} />)}
                            </Steps>
                            <br />
                            <div className="steps-content">
                                {steps[current].content}
                            </div>
                            <div className="steps-action" style={{ float: 'right' }}>
                                {
                                    current > 0
                                    &&
                                    (
                                        <Button style={{ marginLeft: 8 }} onClick={() => this.prev()}>
                                            Quay lại
                                        </Button>
                                    )
                                }
                                {
                                    current < steps.length - 1
                                    && <Button type="primary" onClick={() => this.next()}>Bước tiếp</Button>
                                }
                                {
                                    current === steps.length - 1
                                    && <Button type="primary" onClick={() => message.success('Thanh toán hoàn tất!')}>Thanh toán</Button>
                                }
                            </div>
                        </Card>
                    </Col>
                    <Col span={7} offset={1}>
                        <Card title="Giỏ hàng của bạn" bordered={true} style={{ width: '100%' }}>
                            <p>Card content</p>
                            <p>Card content</p>
                            <p>Card content</p>
                            <Divider></Divider>
                        </Card>
                        <br />
                        <Card title="Chế độ giao hàng" bordered={true} className="center-items" style={{ width: '100%' }}>
                            <div style={{ textAlign: 'center' }}>
                                <Radio.Group onChange={this.onChangeShipMethod} defaultValue="normal" buttonStyle="solid">
                                    <Radio.Button value="default">Mặc định</Radio.Button>
                                    <Radio.Button value="normal">Tiêu chuẩn</Radio.Button>
                                    <Radio.Button value="fast">Nhanh</Radio.Button>
                                </Radio.Group>
                            </div>
                            <br /><br />
                            {shipMethod === 'default' &&
                                <p>Hình thức giao hàng mặc định ..... </p>
                            }
                            {shipMethod === 'normal' &&
                                <p>Hình thức giao hàng tiêu chuẩn ..... </p>
                            }
                            {shipMethod === 'fast' &&
                                <p>Hình thức giao hàng nhanh ..... </p>
                            }
                        </Card>
                    </Col>
                </Row>
            </div>
        );
    }
}


export default Checkout;