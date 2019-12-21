import React from "react";
import { BrowserRouter, Route, Switch, Redirect } from "react-router-dom";

import Login from "./pages/Login/";
import Main from "./pages/Main/";
import NotFound from "./pages/NotFound/";
import SignUp from "./pages/SignUp/";
import Detail from "./pages/ErrorDetailed"

import { isAuthenticated } from "./services/auth";

const PrivateRoute = ({ component: Component, ...rest }) => (
  <Route
    {...rest}
    render={props =>
      isAuthenticated() ? (
        <Component {...props} />
      ) : (
        <Redirect to={{ pathname: "/", state: { from: props.location } }} />
      )
    }
  />
);

export default function Routes() {
  return (
    <BrowserRouter>
      <Switch>
        <Route path="/" exact component={Login} />
        <Route path="/signup" component={SignUp} />
        <PrivateRoute path="/main" component={Main} />
        <PrivateRoute path="/detail" component={Detail} />
        <Route path="*" component={NotFound} />
      </Switch>
    </BrowserRouter>
  );
}
