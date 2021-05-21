import React, {useEffect} from 'react';
import axios from 'axios';

const AllAuthors = props => {
    const {authorsList, setAuthorsList, removeFromDom} = props;

    useEffect(() => {
        axios.get('http://localhost:8000/api/authors')
            .then(response => setAuthorsList(response.data.data))
            .catch(err => console.log(err));
    }, [])

    const deleteAuthor = (authorID) => {
        axios.delete(`http://localhost:8000/api/authors/${authorID}`)
            .then(res => {removeFromDom(authorID)});
    }

    const viewQuotes = (authorID) => {
        window.location = `/quotes/${authorID}`;
    }

    const editAuthor = (authorID) => {
        window.location = `/authors/${authorID}/edit`;
    }


    return (
        <div>
            <h3>We have quotes by:</h3>
            <table>
                <tr>
                    <th><h2>Author</h2></th>
                    <th><h2>Actions available</h2></th>
                </tr>
                {
                    authorsList.map( (author, idx) =>
                        <tr key={idx}>
                            <td><h3>{author.authorName}</h3></td>
                            <td>
                                <button onClick = {e=> {viewQuotes(author._id)}}>View quotes</button>
                                <button onClick = {e=> {editAuthor(author._id)}}>Edit</button>
                                <button onClick = {e => {deleteAuthor(author._id)}}>Delete</button>
                            </td>
                        </tr>
                    )
                }
            </table>
        </div>
    ) // return end
} // function end

export default AllAuthors