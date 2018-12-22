import React, {Component} from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';

import Home from './component/home/Home';
import ShoeDetail from './component/shoe-detail/ShoeDetail';
import Footer from './component/footer/footer';

import {BackTop} from 'antd';
import './App.css';
import Profile from './component/profile/Profile';
import ListShoe from './component/list-shoe/ListShoe';
import Header from './component/header/Header';
import Menu from './component/menu/Menu';

class App extends Component {
    render() {
        return (
            <React.Fragment>
                <BackTop/>
                <div className="container-fluid">
                    <Header/>
                    <Menu/>
                    <Switch>
                        <Route path='/' exact={true} component={Home}/>
                        <Route path='/chi-tiet-giay/:id' component={ShoeDetail}/>
                        <Route path='/thong-tin' component={Profile}/>
                        <Route path='/danh-sach/:id' component={ListShoe}/>
                    </Switch>
                    <Footer/>
                </div>
            </React.Fragment>
        );
    }
}

export default App;
