import React from 'react'
import Box from './Box';
import '../App.css';


const BoxDisplay = props => {
    const {boxArr} = props;

    return (
        <div id="boxSection">
            {
                boxArr.map( (elem, idx) => <Box style={elem} key={idx}></Box>)
            }
        </div>
    )
}

export default BoxDisplay;