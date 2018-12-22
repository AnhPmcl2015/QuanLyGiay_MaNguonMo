import React, { Component } from 'react';
import './Header.css';
import SelectGiay from './SelectGiay';

import { connect } from 'react-redux';
import * as actions from '../../redux/actions/index';
import { list_giay_ban_chay } from './../../redux/actions/index';
import { Icon, Badge, Modal, Col, Row, Button, Input } from 'antd';

class Header extends Component {

    state = {
        count: 0,
        isOpenModal: false,
    }
    openLogin = () => {
        this.setState({
            isOpenModal: true
        })
    }
    handleCancel = () => {
        this.setState({
            isOpenModal: false
        })
    }
    async componentDidMount() {

        if (this.props.giay.listTenGiay.length === 0) {

            await this.getListTenGiay();
        }
    }

    // lấy danh sách tên giày
    getListTenGiay() {
        fetch("/api/ten-giay")
            .then(res => res.json())
            .then(data => {
                console.log(data);
                this.props.getListTenGiay(data)
            }).catch(e => {
                console.log(e);
            });
    }

    handleChange = (value) => {
        this
            .props
            .history
            .push('/chi-tiet-giay/' + value);
    }

    render() {

        var { giay } = this.props;
        return (
            <React.Fragment>
                <header className="row align-items-center">
                    <div className="col-10">
                        <img id="logo" src="/images/logo.png" className="mr-3" alt="Không có hình ảnh" />
                        <SelectGiay listTenGiay={giay.listTenGiay} />
                    </div>

                    <div className="col-2 text-right">
                        <ul className="list-inline">
                            <li className="list-inline-item">
                                <Badge count={5} className="float-right  mr-4">
                                    <a className="icon-size"><Icon type="shopping-cart" /></a>
                                </Badge>
                            </li>
                            <li className="list-inline-item"> <Badge className="float-right" dot>
                                <a className="icon-size" key="yun" onClick={this.openLogin}> <Icon type="login" /></a>
                            </Badge></li>
                        </ul>
                    </div>
                </header>
                <Modal
                    visible={this.state.isOpenModal}
                    title="Đăng nhập"
                    //  onOk={this.handleOk}
                    onCancel={this.handleCancel}
                    footer={[
                        <div></div>
                    ]}
                >
                    <Row>
                        <Col>
                            <label>Tài khoản</label>
                            <Input placeholder="" />
                        </Col>
                        <Col>
                            <label className="mt-2">Mật khẩu</label>
                            <Input placeholder="" type="password" />
                        </Col>
                        <Col>
                            <Button className="mt-2">Đăng nhập</Button>
                        </Col>
                        {/* <Col>
                            <div align="center" className="mt-2">
                                <a href="#">Quên mật khẩu</a>
                            </div>
                        </Col> */}
                        <Col>
                            <div align="center" className="mt-2">
                                <a href="#">Chưa có tài khoản/đăng ký</a>
                            </div>
                        </Col>
                    </Row>
                </Modal>
            </React.Fragment>
        );
    }
}
const mapStateToProps = (state) => {
    return { giay: state.giay }
};

const mapDispatchToProps = (dispatch, props) => {
    return {
        getListTenGiay: (listTenGiay) => {
            dispatch(actions.list_ten_giay(listTenGiay));
        }
    }
}
export default connect(mapStateToProps, mapDispatchToProps)(Header);