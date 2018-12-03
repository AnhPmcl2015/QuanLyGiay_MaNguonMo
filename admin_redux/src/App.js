import React, { Component } from "react";
import Header from "./Admin/Common/Header/header";
import Footer from "./Admin/Common/Footer/footer";
import { Switch } from 'react-router-dom';
import { Route } from 'react-router-dom';
import CreateShoe from './Admin/Shoe/create-shoe/create-shoe';
import EditShoe from './Admin/Shoe/edit-shoe/edit-shoe';
import ListShoe from './Admin/Shoe/list-shoe/list-shoe';
import BadRequest from './Admin/Common/BadRequest/bad-request';
import { getCurrentUser } from './Admin/Common/UserAPI/UserAPI';
import { ACCESS_TOKEN } from './Admin/Common/Constant/common';
import { notification } from 'antd';
import Login from './Admin/Login/Login';
import Invoice from './Admin/Invoice/Invoice';
class App extends Component {
  state = {
    currentUser: null,
    isAuthenticated: false,
    isLoading: false
  }
  loadCurrentUser = () => {
    this.setState({
      isLoading: true
    });
    getCurrentUser()
      .then(response => {
        this.setState({
          currentUser: response,
          isAuthenticated: true,
          isLoading: false
        });
      }).catch(error => {
        this.setState({
          isLoading: false
        });
      });
  }

  handleLogout = (redirectTo = "/", notificationType = "success", description = "Đăng xuất thành công") => {
    localStorage.removeItem(ACCESS_TOKEN);

    this.setState({
      currentUser: null,
      isAuthenticated: false
    });

    this.props.history.push(redirectTo);

    notification[notificationType]({
      message: 'Thông báo',
      description: description,
    });
  }

  handleLogin = () => {
    notification.success({
      message: 'Thông báo',
      description: "Đăng nhập thành công.",
    });
    this.loadCurrentUser();
    this.props.history.push("/");
  }

  componentWillMount() {
    this.loadCurrentUser();
  }

  render() {
    return (
      <div>
        <Header />
        <Switch>
          <Route path="/login" render={(props) => this.state.isAuthenticated ?
            <Invoice /> : <Login onLogin={this.handleLogin} {...props} />}></Route>
          <Route
            path="/admin/danh-sach-giay/them-giay"
            component={CreateShoe}
          />
          <Route
            path="/admin/danh-sach-giay/sua-giay"
            component={EditShoe}
          />
          <Route path="/admin/danh-sach-giay" component={ListShoe} />
          <Route component={BadRequest} />
        </Switch>
        <Footer />
      </div>
    );
  }
}

export default App;
