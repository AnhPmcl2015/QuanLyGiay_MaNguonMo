import React, {Component} from 'react';
import MenuItem from './MenuItem';

import {Collapse, Navbar, NavbarToggler, Nav} from 'reactstrap';
class Menu extends Component {

    constructor(props) {
        super(props);

        this.state = {
            isOpen: false,
            hangSanXuat: []
        };
    }
    toggle = () => {
        this.setState({
            isOpen: !this.state.isOpen
        });
    }

    componentDidMount() {
        this.getListHanSanXuat();
    }

    // lấy danh sách hãng sản xuất
    async getListHanSanXuat() {
        await fetch('/api/hang-san-xuat')
            .then(response => response.json())
            .then(data => this.setState({
                hangSanXuat: data
            }));
    }

    render() {
        var menuItem = this
            .state
            .hangSanXuat
            .map((hangSanXuat, index) => {
                return <MenuItem key={index} hangSanXuat={hangSanXuat}/>
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

export default Menu;