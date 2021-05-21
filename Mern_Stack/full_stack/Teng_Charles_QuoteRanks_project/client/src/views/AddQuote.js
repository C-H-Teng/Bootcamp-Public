import React, {useEffect, useState} from 'react';
import axios from 'axios';
import {navigate, Link} from '@reach/router';
import Form from '../components/Form';

const AddQuote = props => {
    const {id} = props
    const [author, setAuthor] = useState({});
    const [loaded, setLoaded] = useState(false);

    useEffect(() => {
        axios.get(`http://localhost:8000/api/authors/${id}`, author)
            .then(res => {
                console.log(res);
                setAuthor(res.data.data.authorName);
                setLoaded(true);
            })
            .catch(err => console.log(err));
    }, [])

    const createQuote = (quote) => {
        axios.put(`http://localhost:8000/api/quotes/${id}/new`, {quote}) // wrap nested object in {}
            .then(res => {
                console.log(res);
                navigate(`/quotes/${id}`)
            })
            .catch(err => console.log(err));
    }
console.log(author)

    return (
        loaded && (
        <div>
            <h1>Quote Ranks</h1>
            <h3><Link to="/">Home</Link></h3>
            <h3>Provide a quote from {author}:</h3>
            <label>Quote:</label> <br />
            <Form 
                onSubmitProp = {createQuote}
                initialName = ""
            />
        </div>)
    ) // return end
} // function end

export default AddQuote;