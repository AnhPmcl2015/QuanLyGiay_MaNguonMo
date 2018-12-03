import React, { Component } from "react";
import Header from "./Admin/Common/Header/header";
import Footer from "./Admin/Common/Footer/footer";
import { Switch } from 'react-router-dom';
import { Route } from 'react-router-dom';
import MainPage from './Admin/Common/main page/main-page';
import CreateShoe from './Admin/Shoe/create-shoe/create-shoe';
import EditShoe from './Admin/Shoe/edit-shoe/edit-shoe';
import BadRequest from './Admin/Common/BadRequest/bad-request';
class App extends Component {


  render() {
    return (
      <div>
        <Header />
        <Switch>
            <Route
              exact
              path="/"
              render={props => (
                <MainPage
                  text1={"my props text1"}
                  text2={"my props text2"}
                  {...props}
                />
              )}
            />
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
