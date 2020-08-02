import React from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';

import ApiCall from "./ApiCall";
import SpiderMan from "../Pages/SpiderMan.js";
import Header from "./Header";


export default () => (
    <Router>
        <Header/>
        <Route path="/react/test" component={ApiCall}/>
        <Route path="/spiderman" component={SpiderMan}/>
    </Router>
)