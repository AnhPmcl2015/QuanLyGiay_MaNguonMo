import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

import Home from './component/home/Home';
import ShoeDetail from './component/shoe-detail/ShoeDetail';
import Footer from './component/footer/footer';

import { BackTop } from 'antd';
import './App.css';
import Profile from './component/profile/Profile';
import Signup from './component/Signup/Signup';
import Cart from './component/Cart/Cart';
import Checkout from './component/Checkout/Checkout';

class App extends Component {


    render() {
        return (
            <React.Fragment>

                <BackTop />
                <div className="container-fluid">
                    <Switch>
                        <Route path='/' exact={true} component={Home} />
                        <Route path='/chi-tiet-giay/:id' component={ShoeDetail} />
                        <Route path='/thong-tin' component={Profile} />
                        <Route path="/dang-ky" component={Signup} />
                        <Route path="/gio-hang" component={Cart} />
                        <Route path="/thanh-toan" component={Checkout} />
                    </Switch>

                </div>
                <Footer />
            </React.Fragment>
        );
    }
}

export default App;
