import './Checkout.css';
import React, { Component } from 'react';
import { Form, Input, Tooltip, Icon, Select, Button } from 'antd';

const FormItem = Form.Item;
const Option = Select.Option;
const { TextArea } = Input;

class RegistrationForm extends Component {
    state = {
        customer: {
            email: 'dieu556@gmail.com',
            name: 'Nguyễn Tấn Diệu',
            phone: '0822970000',
            address: 'Gò Vấp, HCM',
        },
        isValid: false
    };

    onChange = (e) => {
        e.preventDefault();
        this.props.form.validateFields((err, values) => {
            if (err) {
                this.setState({ isValid: false })
            } else {
                this.setState({ customer: values, isValid: true })
            }
        });
    }

    componentDidMount() {
        const { customer } = this.state;
        this.props.form.setFieldsValue({ 'email': customer.email });
        this.props.form.setFieldsValue({ 'name': customer.name })
        this.props.form.setFieldsValue({ 'phone': customer.phone })
        this.props.form.setFieldsValue({ 'address': customer.address })
    }

    render() {
        const { getFieldDecorator } = this.props.form;
        const formItemLayout = {
            labelCol: {
                xs: { span: 24 },
                sm: { span: 6 },
            },
            wrapperCol: {
                xs: { span: 24 },
                sm: { span: 15 },
            },
        };

        const prefixSelector = getFieldDecorator('prefix', {
            initialValue: '84',
        })(
            <Select style={{ width: 70 }}>
                <Option value="84">+84</Option>
            </Select>
        );

        return (
            <Form onSubmit={this.handleSubmit}>
                <FormItem
                    {...formItemLayout}
                    label={(
                        <span>
                            Email&nbsp;
                <Tooltip title="Chúng tôi sẽ gửi thông tin đơn hàng, thông tin khuyến mãi và các chương trình ưu đãi cho khách hàng">
                                <Icon type="question-circle-o" />
                            </Tooltip>
                        </span>
                    )}
                >
                    {getFieldDecorator('email', {
                        rules: [{
                            type: 'email', message: 'Email không hợp lệ!',
                        }, {
                            required: true, message: 'Email không được trống!',
                        }],
                    })(
                        <Input onChange={this.onChange} />
                    )}
                </FormItem>

                <FormItem
                    {...formItemLayout}
                    label="Tên khách hàng"
                >
                    {getFieldDecorator('name', {
                        rules: [{ required: true, message: 'Tên không được trống!', whitespace: true }],
                    })(
                        <Input onChange={this.onChange} />
                    )}
                </FormItem>

                <FormItem
                    {...formItemLayout}
                    label="Phone Number">
                    {getFieldDecorator('phone', {
                        rules: [{
                            required: true, message: 'Số điện thoại không được trống!',
                        }],
                    })(
                        <Input addonBefore={prefixSelector} style={{ width: '100%' }} onChange={this.onChange} />
                    )}
                </FormItem>
                <FormItem
                    {...formItemLayout}
                    label="Địa chỉ">
                    {getFieldDecorator('address', {
                        rules: [{ required: true, message: 'Địa chỉ không được trống!', whitespace: true }],
                    })(
                        <TextArea placeholder="Địa chỉ nhận hàng" autosize={{ minRows: 2, maxRows: 6 }} onChange={this.onChange} />
                    )}
                </FormItem>
            </Form>
        );
    }
}

class StepOne extends Component {
    state = {
        isValid: false,
        test: 'child content'
    }

    onChange = (e) => {
        console.log('change');
    }

    handler = () => {
        console.log('click child');
        this.props.handler();
        console.log(this.props.test);
    }

    render() {
        const WrappedRegistrationForm = Form.create()(RegistrationForm);
        return (
            <div>
                <Button onClick={this.handler}>abc</Button>
                <WrappedRegistrationForm onChange={this.onChange}/>
            </div>
        );
    }
}

export default StepOne;