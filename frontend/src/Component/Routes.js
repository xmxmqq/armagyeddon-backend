import React from 'react';
import { BrowserRouter as Router, Route, useLocation } from 'react-router-dom';

import Login from "../Pages/Login";
import Header from "./Header";
import Home from "../Pages/Home";

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
                <Route exact  path="/" component={Home}/>
                <Route path="/login" component={Login}/>
                
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