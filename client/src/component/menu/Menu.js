import React, {Component} from 'react';
import MenuItem from './MenuItem';
import {connect} from 'react-redux';
import * as actions from '../../redux/actions/index';

import {Collapse, Navbar, NavbarToggler, Nav} from 'reactstrap';
class Menu extends Component {

    constructor(props) {
        super(props);

        this.state = {
            isOpen: false,
            loaiGiay: [],
        };
    }
    toggle = () => {
        this.setState({
            isOpen: !this.state.isOpen
        });
    }

    async componentDidMount() {

        if (this.props.giay.listLoaiGiay.length === 0) {
            await this.getListLoaiGiay();
        }
    }

    // lấy danh sách Loại giày
     getListLoaiGiay = () => {
         fetch('/api/ten-giay')
            .then(response => response.json())
            .then(data =>{
                
                this.props.getListLoaiGiay(data)
            });
    }

    render() {
        var menuItem = this
            .state
            .loaiGiay
            .map((giay, index) => {
                console.log(giay)
                return <MenuItem key={index} loaiGiay={giay}/>
            });
        return (
            <React.Fragment>
                <Navbar color="dark" dark expand="md">
                    <NavbarToggler onClick={this.toggle}/>
                    <Collapse isOpen={this.state.isOpen} navbar>
                        <Nav className="mx-auto" navbar>
                            {menuItem}
                        </Nav>
                    </Collapse>
                </Navbar>

            </React.Fragment>
        );
    }
}

const mapStateToProps = (state) => {
    return {giay: state.giay}
};

const mapDispatchToProps = (dispatch, props) => {
    return {
        getListLoaiGiay: (listLoaiGiay) => {
            dispatch(actions.list_loai_giay(listLoaiGiay));
        }
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(Menu);