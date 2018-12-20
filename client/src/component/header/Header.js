import React, { Component } from 'react';
import './Header.css';
import SelectGiay from './SelectGiay';

import { connect } from 'react-redux';
import * as actions from '../../redux/actions/index';
import { list_giay_ban_chay } from './../../redux/actions/index';

class Header extends Component {

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
            })

    }

    handleChange = (value) => {
        this
            .props
            .history
            .push('/chi-tiet-giay/' + value);
    }

    render() {

        var { giay } = this.props;
        // console.log(giay)
        if (giay.listGiayBanChay.length === 0) {
            return <div>Loading...</div>
        }
        return (

            <React.Fragment>
                <header className="row align-items-center">
                    <div className="col-10">
                        <img id="logo" src="/images/logo.png" className="mr-3" alt="Không có hình ảnh" />
                        <SelectGiay listTenGiay={giay.listTenGiay}/>
                    </div>

                    <div className="col-2 text-right">
                        <ul className="list-inline">
                            <li className="list-inline-item">Đăng nhập |</li>
                            <li className="list-inline-item">$0
                                <i className="fa fa-arrow-down"></i>
                            </li>
                        </ul>
                    </div>
                </header>
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