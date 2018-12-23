import React, { Component } from 'react';
import { Tabs } from 'antd';
import Info from './Info';
import Order from './Ordered';
import Address from './Address';
import Header from './../header/Header';
import Menu from './../menu/Menu';

const TabPane = Tabs.TabPane;

class Profile extends Component {

    state = {
        loggedUser: null
    }

    componentWillReceiveProps() {
        const loggedUser = JSON.parse(localStorage.getItem('loggedUser'));
        if (loggedUser !== null) {
            this.setState({
                loggedUser: loggedUser
            })
            console.log(loggedUser)
        }
    }

    render() {
        const user = this.state.loggedUser;
        return (
           
            <div>
                <Tabs
                    defaultActiveKey="1"
                    tabPosition="left"
                    style={{
                        height: ''
                    }}>
                    <TabPane tab="Thông tin" key="1">
                        <Info loggedUser={user}/>
                    </TabPane>
                    {/* <TabPane tab="Quản lý địa chỉ" key="2">
                        <Address/>
                    </TabPane> */}
                    <TabPane tab="Đơn hàng" key="3">
                        <Order />
                    </TabPane>
                </Tabs>
            </div>
        );
    }
}

export default Profile;
