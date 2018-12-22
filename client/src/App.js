import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

import Home from './component/home/Home';
import ShoeDetail from './component/shoe-detail/ShoeDetail';
import Footer from './component/footer/footer';

import { BackTop, Affix } from 'antd';
import './App.css';
import Profile from './component/profile/Profile';
import Header from './component/header/Header';
import Menu from './component/menu/Menu';

class App extends Component {


    render() {
        return (
            <React.Fragment>

                <BackTop />

                <Header />
                <Affix offsetTop={0}>
                    <Menu />
                </Affix>

                <div className="container-fluid">
                    <Switch>
                        <Route path='/' exact={true} component={Home} />
                        <Route path='/chi-tiet-giay/:id' component={ShoeDetail} />
                        <Route path='/thong-tin' component={Profile} />
                    </Switch>
                </div>
                <Footer />
            </React.Fragment>
        );
    }
}

export default App;
