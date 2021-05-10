import React from 'react'
import styled from "styled-components";

const Box = props => {
    const {style} = props;

    const StyledBox = styled.div`
        background: ${style.color};
        width: ${style.size}px;
        height: ${style.size}px;
        margin: 5px;
    `;

    return (
        <div>
            <StyledBox></StyledBox>
        </div>
    )

}

export default Box;