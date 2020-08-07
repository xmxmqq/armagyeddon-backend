import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

import Login from "../Pages/Login";
import Header from "./Header";
import Home from "../Pages/Home";
import AuthenticatedRoute from '../config/AuthenticatedRoute';
import WelcomeComponent from './login/WelcomeComponent';

class Routes extends React.Component {
    constructor(props){
        super(props);
        // this.state = {location: useLocation()};
    }
    render() {
        return(
            <Router>
                <Header/>
                {/* {this.state.location} */}
                <Switch>
                    <Route exact  path="/" component={Home}/>
                    <Route path="/login" component={Login}/>
                    <AuthenticatedRoute path="/welcome/:name" component={WelcomeComponent}/>
                    <AuthenticatedRoute path="/logout" component={Home}/>
                </Switch>
                
                
            </Router>
        );
    }
}

export default Routes;
// export default () => (
//     <Router>
//         <Header/>
//         <Route exact  path="/" component={Home}/>
//         <Route path="/login" component={Login}/>
        
//     </Router>
// )