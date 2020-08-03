import React from 'react';
import { Link } from "react-router-dom";
import styles from '../static/css/header.css';



class Header extends React.Component {
    render() {

        return (
            
            <section id="home" className="section bg-voilet bg-overlay overflow-hidden d-flex align-items-center">
                <div className="container">
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
                    
                
                </div>
                
                
                
            </section>
            
           
           
        );
    }
    
}

export default Header;