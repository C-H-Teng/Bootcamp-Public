import React, {useEffect, useState} from 'react';
import axios from 'axios';
import {Link, navigate} from '@reach/router';
import Form from '../components/Form';

const AddAuthor = () => {

    const createAuthor = (authorName) => {
        axios.post('http://localhost:8000/api/authors/new', {
            authorName
        }) // post line end
            .then(res => {
                console.log(res);
                navigate("/");
            })
            .catch(err => console.log(err));
    }


    return(
        <div>
            <h1>Quote Ranks</h1>
            <h3><Link to="/">Home</Link></h3>
            <h3>Add a new quotable author:</h3>
            <label>Name:</label> <br />
            <Form 
                onSubmitProp = {createAuthor}
                initialName = ""
            />
        </div>
    ) // return end
} // function end

export default AddAuthor