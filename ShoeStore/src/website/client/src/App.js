import React, {Component} from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';

import Home from './component/home/Home';
import ShoeDetail from './component/shoe-detail/ShoeDetail';
import Footer from './component/footer/footer';
import {BackTop} from 'antd';
import './App.css';

class App extends Component {
    render() {
        return (
            <React.Fragment>
                <BackTop/>
                <div className="container-fluid">
                    <Router>
                        <Switch>
                            <Route path='/' exact={true} component={Home}/>
                            <Route path='/chi-tiet-giay/:id' component={ShoeDetail}/>
                        </Switch>
                    </Router>
                    <Footer/>
                </div>
            </React.Fragment>
        );
    }
}

export default App;
