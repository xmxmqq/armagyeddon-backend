import React from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';

import Login from "../Pages/Login";
import SpiderMan from "../Pages/SpiderMan";
import Header from "./Header";


export default () => (
    <Router>
        <Header/>
        <Route path="/login" component={Login}/>
        <Route path="/spiderman" component={SpiderMan}/>
    </Router>
)