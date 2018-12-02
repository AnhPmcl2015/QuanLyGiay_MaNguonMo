import React, {Component} from 'react';
import MenuItem from './MenuItem';

import {
    Collapse,
    Navbar,
    NavbarToggler,
    Nav
} from 'reactstrap';
class Menu extends Component {

    constructor(props) {
        super(props);

        this.state = {
            isOpen: false,
            loaiGiay: [
                {
                    tenLoaiGiay: 'Air Jordans',
                    loaiGiayCon: [
                        {
                            maGiay: '1',
                            ten: 'Air Jordans 1'
                        }, {
                            maGiay: '2',
                            ten: 'Air Jordans 2'
                        }
                    ]
                }, {
                    tenLoaiGiay: 'Nike',
                    loaiGiayCon: [
                        {
                            maGiay: '1',
                            ten: 'Nike 1'
                        }, {
                            maGiay: '2',
                            ten: 'Nike 2'
                        }
                    ]
                }, {
                    tenLoaiGiay: 'Adidas',
                    loaiGiayCon: [
                        {
                            maGiay: '1',
                            ten: 'Adidas 1'
                        }, {
                            maGiay: '2',
                            ten: 'Adidas 2'
                        }
                    ]
                }, {
                    tenLoaiGiay: 'Yeezy',
                    loaiGiayCon: [
                        {
                            maGiay: '1',
                            ten: 'Yeezy 1'
                        }, {
                            maGiay: '2',
                            ten: 'Yeezy 2'
                        }
                    ]
                }, {
                    tenLoaiGiay: 'Vans',
                    loaiGiayCon: [
                        {
                            maGiay: '1',
                            ten: 'Vans 1'
                        }, {
                            maGiay: '2',
                            ten: 'Vans 2'
                        }
                    ]
                }
            ]
        };
    }
    toggle = () => {
        this.setState({
            isOpen: !this.state.isOpen
        });
    }

    render() {
        var menuItem = this.state.loaiGiay.map((giay, index) => {
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

export default Menu;