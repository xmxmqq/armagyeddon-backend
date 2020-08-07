import React from 'react';


class ApiCall extends React.Component {
    constructor(props){
        super(props);
        this.state = {
            apisay: null,
        };
      }
    
      componentDidMount(){
          fetch("/react/test")
          .then(res => res.json())
          .then(
              (result) => {
                  this.setState({
                      apisay: result.springboot,
    
                  });
              },
    
    
          )
      }


      render(){
        const {apisay} = this.state;
  

        return (
  
  
            <div>
              <h1>
                Learn React
              </h1>
              {apisay}
            </div>
        );
    }
}

export default ApiCall;