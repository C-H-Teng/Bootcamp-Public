import React, {useState} from 'react';
import {navigate} from '@reach/router';

const Form = props => {
    const {initialName, onSubmitProp} = props;
    const [submitValue, setsubmitValue] = useState(initialName);

    const submitHandler = e => {
        e.preventDefault();
        onSubmitProp(submitValue);
    }


    return (
        <form onSubmit = {submitHandler}>
            <input type="text" name="formText" value={submitValue} onChange = {e => setsubmitValue(e.target.value)} /> <br />
            <button type="submit" value="submit">Submit</button>
            <button onClick = {e => navigate("/")}>Cancel</button>
        </form>
    ) // return end
} // function end



export default Form