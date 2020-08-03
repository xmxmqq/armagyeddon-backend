import React from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';

import Login from "../Pages/Login";
import SpiderMan from "../Pages/SpiderMan";
import Header from "./Header";
import Index from "../Pages/Index";

export default () => (
    <Router>
        <Header/>
        <Route path="/home" component={Index}/>
        <Route path="/login" component={Login}/>
        <Route path="/spiderman" component={SpiderMan}/>
    </Router>
)