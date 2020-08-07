import React from 'react';
import { Link } from "react-router-dom";
import AuthenticationService from '../services/AuthenticationService';
import styles from '../static/css/header.css';



class Header extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            isUserLoggedIn: AuthenticationService.isUserLoggedIn(),
            welcomPath: '/welcome/' + AuthenticationService.getLoggedInUserEmail(),
        };
    }

    render() {

        return (
            
            <section id="home" className="section bg-voilet bg-overlay overflow-hidden d-flex align-items-center">
                <div className="container">
                    {
                        !this.state.isUserLoggedIn &&
                        <div className="button-group store-buttons d-flex">
                        
                            <Link to="/" className="btn btn-primary slide_right_alt">
                                Home
                            </Link>
                            
                            <Link to="/login" className="btn btn-primary slide_right_alt">
                                Sign In 
                            </Link>
                            
                            <Link to="/sign-up" className="btn btn-primary slide_left_alt">
                                Sign Up
                            </Link>
                        </div>  
                    }
                    {
                        this.state.isUserLoggedIn &&
                        <div className="button-group store-buttons d-flex">
                            
                            <Link to="/" className="btn btn-primary slide_right_alt">
                                Home
                            </Link>
                            
                            <Link to="/logout" className="btn btn-primary slide_left_alt"  
                                    onClick={AuthenticationService.logout}>Logout
                            </Link>
                        </div> 
                    }
                        
                    
                
                </div>
                
                
                
            </section>
            
           
           
        );
    }
    
}

export default Header;