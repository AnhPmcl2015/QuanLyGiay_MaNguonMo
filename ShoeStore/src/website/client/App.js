import React, {Component} from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

import Menu from './component/menu/Menu';
import Header from './component/header/Header';
import Home from './component/home/Home';

class App extends Component {
    render() {
        return (
            <React.Fragment>
                <div className="container-fluid">
                    <Header/>
                    <Menu/>
                    <Router>
                        <Switch>
                            <Route path='/' exact={true} component={Home}/>
                        </Switch>
                    </Router>
                    
                </div>
            </React.Fragment>
        );
    }
}

export default App;
