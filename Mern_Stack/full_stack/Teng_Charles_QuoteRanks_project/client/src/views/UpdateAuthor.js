import React, {useEffect, useState} from 'react';
import axios from 'axios';
import {Link, navigate} from '@reach/router';
import Form from '../components/Form';

const UpdateAuthor = props => {
    const {id, initialName} = props;
    const [authorName, setAuthorName] = useState(initialName);
    const [loaded, setLoaded] = useState(false);

    useEffect(() => {
        axios.get(`http://localhost:8000/api/authors/${id}`)
            .then(res => {
                setAuthorName(res.data.data.authorName);
                setLoaded(true);
            })
            .catch(err => console.log(err));
    }, [])

    const updateAuthor = authorName => {
        axios.put(`http://localhost:8000/api/authors/${id}/update`, authorName)
            .then(res => {
                console.log(res);
                navigate("/");
            })
            .catch(err => console.log(err));
    }


    return (
        <div>
            <h1>Quote Ranks</h1>
            <h3><Link to="/">Home</Link></h3>
            <h3>Edit {authorName}'s name:</h3>
            <label>Name:</label> <br />
            {loaded && (
                <Form 
                    onSubmitProp = {updateAuthor}
                    initialName = {authorName}
                />
            )}
        </div>
    ) // return end
} // function end

export default UpdateAuthor