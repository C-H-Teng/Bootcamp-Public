import React, {Component} from 'react';

class Person extends Component{
    constructor(props){
        super(props);
        this.state = {
            age: this.props.age
        };
    }

    render(){
        return(
            <div>
                <h1>{this.props.lastName}, {this.props.firstName}</h1>
                <p>Age: {this.state.age}</p>
                <p>Hair Color: {this.props.hairColor}</p>
                <button onClick={ () => {this.setState({age: this.state.age += 1})}}>{this.props.firstName} {this.props.lastName}'s birthday button</button>
            </div> // return div end
        )
    }
}

export default Person;