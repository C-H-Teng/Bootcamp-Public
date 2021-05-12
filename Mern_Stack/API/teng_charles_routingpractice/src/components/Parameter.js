import React from 'react';

const Parameter = props => {
    const {id} = props;


    return (
            isNaN(id)
            ? <h1>The word is: {id}</h1>
            : <h1>The number is: {id}</h1>
    );
}

export default Parameter