import React, {Component} from 'react';
import {Tabs} from 'antd';
import Info from './Info';
import Order from './Ordered';
import Address from './Address';
import Header from './../header/Header';
import Menu from './../menu/Menu';

const TabPane = Tabs.TabPane;

class Profile extends Component {
    constructor(props) {
        super(props);
        this.state = {};
    }

    render() {
        return (

            <div>
                <Header/>
                <Menu/>
                <Tabs
                    defaultActiveKey="1"
                    tabPosition="left"
                    style={{
                    height: ''
                }}>
                    <TabPane tab="Thông tin" key="1">
                        <Info/>
                    </TabPane>
                    <TabPane tab="Quản lý địa chỉ" key="2">
                        <Address/>
                    </TabPane>
                    <TabPane tab="Đơn hàng" key="3">
                        <Order/>
                    </TabPane>
                </Tabs>
            </div>
        );
    }
}

export default Profile;
