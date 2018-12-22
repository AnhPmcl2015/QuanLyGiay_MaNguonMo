import { Form, Input, Tooltip, Icon, Select, Button, Row, Col } from 'antd';
import React, { Component } from 'react';

class Info extends Component {
    render() {
        const Form1 = Form.create()(InfoForm);
        const Form2 = Form.create()(PasswordForm);
        return (
            <Row>
                <Col lg={12}>
                    <Form1 />
                </Col>
                <Col lg={12}>
                    <Form2 />
                </Col>
            </Row >
        );
    }
}

const FormItem = Form.Item;
const Option = Select.Option;
const { TextArea } = Input;

class InfoForm extends Component {
    state = {
        confirmDirty: false,
        autoCompleteResult: [],
    };

    handleSubmit = (e) => {
        e.preventDefault();
        this.props.form.validateFieldsAndScroll((err, values) => {
            if (!err) {
                console.log('Received values of form: ', values);
            } else {
                console.log('ccc1111 ', values);
            }
        });
    }


    handleConfirmBlur = (e) => {
        const value = e.target.value;
        this.setState({ confirmDirty: this.state.confirmDirty || !!value });
    }

    compareToFirstPassword = (rule, value, callback) => {
        const form = this.props.form;
        if (value && value !== form.getFieldValue('password')) {
            callback('Two passwords that you enter is inconsistent!');
        } else {
            callback();
        }
    }

    validateToNextPassword = (rule, value, callback) => {
        const form = this.props.form;
        if (value && this.state.confirmDirty) {
            form.validateFields(['confirm'], { force: true });
        }
        callback();
    }

    render() {
        const { getFieldDecorator } = this.props.form;

        const formItemLayout = {
            labelCol: {
                xs: { span: 24 },
                sm: { span: 7 },
            },
            wrapperCol: {
                xs: { span: 24 },
                sm: { span: 10 },
            },
        };
        const tailFormItemLayout = {
            wrapperCol: {
                xs: {
                    span: 18,
                    offset: 0,
                },
                sm: {
                    span: 9,
                    offset: 15,
                },
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
                    label="Họ tên"
                >
                    {getFieldDecorator('tenKhachHang', {
                        rules: [
                            { required: true, message: 'Họ và tên không được trống' },
                            { max: 100, message: "Số kí tự tối đa là 100!" }
                        ],
                    })(
                        <Input style={{ width: '100%' }} />
                    )}
                </FormItem>
                <FormItem
                    {...formItemLayout}
                    label="Số điện thoại"
                >
                    {getFieldDecorator('soDienThoai', {
                        rules: [
                            { required: true, message: 'Số điện thoại không được trống' },
                            { max: 10, message: "Số kí tự tối đa là 10!" }
                        ],
                    })(
                        <Input addonBefore={prefixSelector} style={{ width: '100%' }} />
                    )}
                </FormItem>
                <FormItem
                    {...formItemLayout}
                    label="Địa chỉ"
                >
                    {getFieldDecorator('diaChi', {
                        rules: [{ required: true, message: 'Địa chỉ không được trống' },
                        { max: 500, message: "Số kí tự tối đa là 500!" }],
                    })(
                        <div>
                            <TextArea placeholder="" autosize={{ minRows: 2, maxRows: 6 }} />
                        </div>
                    )}
                </FormItem>
                <FormItem {...tailFormItemLayout}>

                    <Button type="primary" htmlType="submit">Lưu</Button>
                </FormItem>
            </Form>
        );
    }
}

class PasswordForm extends Component {

    handlePassword = (e) => {
        e.preventDefault();
        this.props.form.validateFieldsAndScroll((err, values) => {
            if (!err) {
                console.log('Received values of form: ', values);
            } else {
                console.log('ccc ', values);
            }
        });
    }

    render() {
        const { getFieldDecorator } = this.props.form;

        const formItemLayout = {
            labelCol: {
                xs: { span: 24 },
                sm: { span: 7 },
            },
            wrapperCol: {
                xs: { span: 24 },
                sm: { span: 10 },
            },
        };
        const tailFormItemLayout = {
            wrapperCol: {
                xs: {
                    span: 18,
                    offset: 0,
                },
                sm: {
                    span: 9,
                    offset: 15,
                },
            },
        };
        return (
            <Form onSubmit={this.handlePassword}>
                <FormItem
                    {...formItemLayout}
                    label="Mật khẩu cũ"
                >
                    {getFieldDecorator('password', {
                        rules: [{
                            required: true, message: 'Please input your password!',
                        }, {
                            validator: this.validateToNextPassword,
                        }],
                    })(
                        <Input type="password" />
                    )}
                </FormItem>
                <FormItem
                    {...formItemLayout}
                    label="Mật khẩu mới"
                >
                    {getFieldDecorator('confirm', {
                        rules: [{
                            required: true, message: 'Please confirm your password!',
                        }, {
                            validator: this.compareToFirstPassword,
                        }],
                    })(
                        <Input type="password" onBlur={this.handleConfirmBlur} />
                    )}
                </FormItem>
                <FormItem {...tailFormItemLayout}>
                    <Button type="primary" htmlType="submit">Lưu</Button>
                </FormItem>
            </Form>
        );
    }

};

export default Info;
