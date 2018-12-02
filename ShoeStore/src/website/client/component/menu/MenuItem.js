import React, {Component} from 'react';
import {UncontrolledDropdown, DropdownToggle, DropdownMenu, DropdownItem} from 'reactstrap';

class MenuItem extends Component {

    render() {
        var {loaiGiay} = this.props;
        var listLoaiGiayCon = loaiGiay.loaiGiayCon.map((con, index) => {
            return <DropdownItem key={index}>
                <a href={con.maGiay}>{con.ten}</a>
            </DropdownItem>
        });
        return (

            <React.Fragment>
                <UncontrolledDropdown className="mr-5" nav inNavbar>
                    <DropdownToggle nav>
                        {loaiGiay.tenLoaiGiay}
                    </DropdownToggle>

                    <DropdownMenu>
                       {listLoaiGiayCon}
                    </DropdownMenu>
                </UncontrolledDropdown>
            </React.Fragment>
        );
    }
}

export default MenuItem;