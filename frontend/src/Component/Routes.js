import React from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';

import Aladin from "../Pages/Aladin.js";
import SpiderMan from "../Pages/SpiderMan.js";
import Header from "./Header";


export default () => (
    <Router>
        <Header/>
        <Route path="/aladin" component={Aladin}/>
        <Route path="/spiderman" component={SpiderMan}/>
    </Router>
)