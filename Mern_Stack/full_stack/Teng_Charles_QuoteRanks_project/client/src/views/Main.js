import React, {useState, useEffect} from 'react';
import axios from 'axios';
import {Link} from '@reach/router';
import AllAuthors from '../components/AllAuthors';

const Main = () => {
    const [authorsList, setAuthorsList] = useState([]);
    const [loaded, setLoaded] = useState(false);

    useEffect(() => {
        axios.get('http://localhost:8000/api/authors')
            .then(res => {
                setAuthorsList(res.data.data);
                setLoaded(true);
            });
    }, [])

    const removeFromDom = authorID => {
        setAuthorsList(authorsList.filter(author => author._id !== authorID));
    }


    return (
        <div>
            <h1>Quote Ranks</h1>
            <h3><Link to="/new">Add a quotable author</Link></h3>

            {loaded && <AllAuthors 
                authorsList = {authorsList}
                setAuthorsList = {setAuthorsList}
                removeFromDom = {removeFromDom}
            />}
        </div>
    )// return end
} // function end

export default Main;