import React, {Component} from 'react';
import './Header.css';
import {connect} from 'react-redux';
import * as actions from '../../redux/actions/index';


class Header extends Component {

    componentDidMount() {
        fetch('api/ten-giay')
            .then(response => response.json())
            .then(data => this.props.getListTenGiay(data));

    }

    render() {
        var {giay} = this.props;
        console.log(giay);
        return (

            <React.Fragment>
                <header className="row align-items-center">
                    <div className="col-lg-8 col-xl-10">
                        <img id="logo" src="/images/logo.png" className="mr-3" alt="Không có hình ảnh"/>
                    </div>

                    <div className="col-lg-4 col-xl-2 text-right">
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