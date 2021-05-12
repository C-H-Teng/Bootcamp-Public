import React from 'react';

const ParamColor = props => {
    const {id, txtClr, bgClr} = props;

    const color =  {
        backgroundColor: bgClr,
        color: txtClr
    };

    return (
            isNaN(id)
            ? <h1 style={color}>The word is: {id}</h1>
            : <h1 style={color}>The number is: {id}</h1>
    );
}

export default ParamColor