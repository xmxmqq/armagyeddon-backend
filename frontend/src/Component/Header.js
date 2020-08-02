import React from 'react';
import { Link } from "react-router-dom";

class Header extends React.Component {
    render() {

        return (
            <section id="home" className="section bg-voilet bg-overlay overflow-hidden d-flex align-items-center">
                <div className="container">
                            
                        <Link to="/login" className="btn btn-primary slide_right_alt">
                            Sign In 
                        </Link>
                        
                        <Link to="/sign-up" className="btn btn-primary slide_left_alt">
                            Sign Up
                        </Link>
                
                </div>
            </section>
           
        );
    }
    
}

export default Header;