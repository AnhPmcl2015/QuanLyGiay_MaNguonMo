import { Form, Input, Tooltip, Icon, Select, Button } from 'antd';
import React, { Component } from 'react';

class Info extends Component {
    render() {
        const AntWrappedLoginForm = Form.create()(InfoForm)
        return (
            <AntWrappedLoginForm />
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
                    span: 24,
                    offset: 0,
                },
                sm: {
                    span: 24,
                    offset: 16,
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
                    label={(
                        <span>
                            Tên tài khoản&nbsp;
                            <Tooltip title="Tài khoản dùng đê đăng nhập">
                                <Icon type="question-circle-o" />
                            </Tooltip>
                        </span>
                    )}
                >
                    {getFieldDecorator('nickname', {
                        rules: [{ required: true, message: 'Please input your nickname!', whitespace: true }],
                    })(
                        <Input />
                    )}
                </FormItem>
                <FormItem
                    {...formItemLayout}
                    label={(
                        <span>
                            E-mail&nbsp;
                            <Tooltip title="Email nhận thông tin promotion hoặc thông tin đơn hàng">
                                <Icon type="question-circle-o" />
                            </Tooltip>
                        </span>
                    )}
                >
                    {getFieldDecorator('email', {
                        rules: [{
                            type: 'email', message: 'The input is not valid E-mail!',
                        }, {
                            required: true, message: 'Please input your E-mail!',
                        }],
                    })(
                        <Input />
                    )}
                </FormItem>
                <FormItem
                    {...formItemLayout}
                    label="Mật khẩu"
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
                    label="Xác nhận mật khẩu"
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
                <FormItem
                    {...formItemLayout}
                    label="Số điện thoại"
                >
                    {getFieldDecorator('phone', {
                        rules: [{ required: true, message: 'Please input your phone number!' }],
                    })(
                        <Input addonBefore={prefixSelector} style={{ width: '100%' }} />
                    )}
                </FormItem>
                <FormItem
                    {...formItemLayout}
                    label="Địa chỉ"
                >
                    {getFieldDecorator('website', {
                        rules: [{ required: true, message: 'Please input website!' }],
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

export default Info;
