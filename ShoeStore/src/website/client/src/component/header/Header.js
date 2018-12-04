import React, {Component} from 'react';
import './Header.css';
import SelectGiay from './SelectGiay';

import {connect} from 'react-redux';
import * as actions from '../../redux/actions/index';


class Header extends Component {

    constructor(props) {
        super(props);
        this.handleChange = this
            .handleChange
            .bind(this);
        this.getListTenGiay();
    }
 

    // lấy danh sách tên giày
    async getListTenGiay() {
        await fetch('/api/ten-giay')
            .then(response => response.json())
            .then(data => this.props.getListTenGiay(data));
    }

    handleChange(value) {
        this.props.history.push('/chi-tiet-giay/' + value);
    }

    render() {

        var {giay} = this.props;

        return (

            <React.Fragment>
                <header className="row align-items-center">
                    <div className="col-10">
                        <img id="logo" src="/images/logo.png" className="mr-3" alt="Không có hình ảnh"/>
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
    return {giay: state.giay}
};

const mapDispatchToProps = (dispatch, props) => {
    return {
        getListTenGiay: (listTenGiay) => {
            dispatch(actions.list_ten_giay(listTenGiay));
        }
    }
}
export default connect(mapStateToProps, mapDispatchToProps)(Header);