import React from 'react';
import AuthenticationService from '../services/AuthenticationService';
import styles from '../static/css/login.css'

class Login extends React.Component {

    constructor(props) {
        super(props)
        
        this.state = {
            email: localStorage.getItem("authenticatedUser") || '',
            password: '',
            token: localStorage.getItem("token") || '',
            hasLoginFailed: false,
            showSuccessMessage: false
        }
        this.handleChange = this.handleChange.bind(this)
        this.loginClicked = this.loginClicked.bind(this)
    }

    handleChange(event) {
        this.setState(
            {
                [event.target.name]
                  :event.target.value
            }
        )
    }

    loginClicked() {
        AuthenticationService
        // get email, password at the form
        .executeJwtAuthenticationService(this.state.email, this.state.password)
        .then((response) => {
            console.log(response)
            this.setState({
                token: response.data.token
            });
            AuthenticationService.registerSuccessfulLoginForJwt(this.state.email,this.state.token)
            this.props.history.push(`/welcome/${this.state.email}`)
        }).catch( () =>{
            this.setState({showSuccessMessage:false})
            this.setState({hasLoginFailed:true})
        })
    }

    render() {
        return(

            <div className="container h-100">
                <div className="d-flex justify-content-center h-100">
                    <div className="user_card">
                        <div className="d-flex justify-content-center">
                            <div className="brand_logo_container">
                                <img src="/images/icon2.png" className="brand_logo" alt="Logo"/>
                            </div>
                        </div>
                        <div className="d-flex justify-content-center form_container">
                            
                            <div className="input-group mb-3">
                                <div className="input-group-append">
                                    <span className="input-group-text"><i className="fas fa-user"></i></span>
                                </div>
                                <input type="email" name="email" className="form-control input_user" 
                                    value={this.state.email} onChange={this.handleChange} placeholder="username"/>
                            </div>
                            <div className="input-group mb-2">
                                <div className="input-group-append">
                                    <span className="input-group-text"><i className="fas fa-key"></i></span>
                                </div>
                                <input type="password" name="password" className="form-control input_pass" 
                                    value={this.state.password}  onChange={this.handleChange} placeholder="password"/>
                            </div>
                            {/* <div className="form-group">
                                <div className="custom-control custom-checkbox">
                                    <input type="checkbox" className="custom-control-input" id="customControlInline"/>
                                    <label className="custom-control-label" for="customControlInline">Remember me</label>
                                </div>
                            </div> */}
                            <div className="d-flex justify-content-center mt-3 login_container">
                                <button className="btn login_btn" onClick={this.loginClicked} >Login</button>
                            </div>
                            
                        </div>
                
                        <div className="mt-4">
                            <div className="d-flex justify-content-center links">
                                Don't have an account? <a href="/sign-up" className="ml-2">Sign Up</a>
                            </div>
                            <div className="d-flex justify-content-center links">
                                <a href="#">Forgot your password?</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Login;