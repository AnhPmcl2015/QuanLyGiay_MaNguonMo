import React, { Component } from "react";
import Header from "./Admin/Common/Header/header";
import Footer from "./Admin/Common/Footer/footer";
import { Switch } from 'react-router-dom';
import { Route } from 'react-router-dom';
import CreateShoe from './Admin/Shoe/create-shoe/create-shoe';
import EditShoe from './Admin/Shoe/edit-shoe/edit-shoe';
import ListShoe from './Admin/Shoe/list-shoe/list-shoe';
import BadRequest from './Admin/Common/BadRequest/bad-request';
class App extends Component {


  render() {
    return (
      <div>
        <Header />
        <Switch>
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
