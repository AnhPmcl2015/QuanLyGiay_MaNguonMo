import React, { Component } from 'react';
import { UncontrolledDropdown, DropdownToggle, DropdownMenu, DropdownItem } from 'reactstrap';
import { Link } from 'react-router-dom';

class MenuItem extends Component {

    constructor(props) {
        super(props);

        this.state = {
            listLoaiGiay: []
        };
    }

    async componentDidMount() {
        await this.getListLoaiGiay();
    }

     getListLoaiGiay() {
         fetch('/api/hang-san-xuat/loai-giay/' + this.props.hangSanXuat.idHangSanXuat)
            .then(response => response.json())
            .then(data => this.setState({ listLoaiGiay: data }));
    }

    reload = () => {
        window.location.reload();
    }

    render() {
        var { hangSanXuat } = this.props;

        var listLoaiGiay = this
            .state
            .listLoaiGiay
            .map((loaiGiay, index) => {
                return <DropdownItem key={index} onClick={this.reload}>
                    <Link to={"/danh-sach/" + loaiGiay.id}>
                        {loaiGiay.tenLoaiGiay}
                    </Link>
                </DropdownItem>
            })

        return (

            <React.Fragment>
                <UncontrolledDropdown className="mr-5" nav inNavbar>
                    <DropdownToggle nav>
                        {hangSanXuat.tenHangSanXuat}
                    </DropdownToggle>

                    <DropdownMenu>
                        {listLoaiGiay}
                    </DropdownMenu>
                </UncontrolledDropdown>
            </React.Fragment>
        );
    }
}

export default MenuItem;