import React, {useState, useEffect} from 'react';
import axios from 'axios';
import {Link} from '@reach/router';

const QuotesList = props => {
    const {id} = props;
    const [authorName, setAuthorName] = useState("");
    const [loaded, setLoaded] = useState(false);
    const [quoteList, setQuoteList] = useState([]);
    const [voteCount, setVoteCount] = useState(0);

    useEffect(() => {
        axios.get(`http://localhost:8000/api/authors/${id}`)
            .then(res => {
                setAuthorName(res.data.data.authorName);
                setQuoteList(res.data.data.quoteList);
                setLoaded(true);
            })
            .catch(err => console.log(err));
    }, [])

    const voteUp = quoteIdx => {
        axios.get(`http://localhost:8000/api/authors/${id}`)
            .then(res => {
                // console.log(res.data.data.quoteList[quoteIdx].voteCount);
                let count = res.data.data.quoteList[quoteIdx].voteCount;
                let quoteID = res.data.data.quoteList[quoteIdx]._id;
                setVoteCount(count + 1);
                axios.put(`http://localhost:8000/api/quotes/${id}/vote/${quoteID}`, {voteCount: count + 1})
                    .then(res => {
                        console.log(res)
                        setAuthorName(res.data.data.authorName);
                        setQuoteList(res.data.data.quoteList);
                    })
                    .catch(err => console.log(err));
            })
    }

    const voteDown = quoteIdx => {
        axios.get(`http://localhost:8000/api/authors/${id}`)
            .then(res => {
                // console.log(res.data.data.quoteList[quoteIdx].voteCount);
                let count = res.data.data.quoteList[quoteIdx].voteCount;
                let quoteID = res.data.data.quoteList[quoteIdx]._id;
                setVoteCount(count - 1);
                axios.put(`http://localhost:8000/api/quotes/${id}/vote/${quoteID}`, {voteCount: count - 1})
                    .then(res => {
                        console.log(res)
                        setAuthorName(res.data.data.authorName);
                        setQuoteList(res.data.data.quoteList);
                    })
                    .catch(err => console.log(err));
            })
    }

    const deleteQuote = quoteIdx => {
        axios.get(`http://localhost:8000/api/authors/${id}`)
            .then(res => {
                let quoteID = res.data.data.quoteList[quoteIdx]._id;
                // console.log(quoteID);
                // console.log(quoteIdx)
                axios.delete(`http://localhost:8000/api/quotes/${id}/delete/${quoteID}`, {quoteID})
                    .then(res => {
                        console.log(res)
                        setAuthorName(res.data.data.authorName);
                        setQuoteList(res.data.data.quoteList);
                    })
                    .catch(err => console.log(err));
            })
    }


    return (
        <>
            {loaded && (
                <div>
                    <h1>Quote Ranks</h1>
                    <div className="row">
                        <h3><Link to="/">Home</Link></h3>
                        <h3><Link to={`/quotes/${id}/new`}>Add a quote</Link></h3>
                    </div>
                    <h3>Quotes by {authorName}:</h3>
                    <table>
                        <tr>
                            <th><h2>Quotes</h2></th>
                            <th><h2>Votes</h2></th>
                            <th><h2>Actions available</h2></th>
                        </tr>
                        {
                            quoteList.map( (quote, idx) =>
                                <tr key={idx}>
                                    <td><h3>{quote.quote}</h3></td>
                                    <td><h3>{quote.voteCount}</h3></td>
                                    <td>
                                        <button onClick = {e=> {voteUp(idx)}}>Vote up</button>
                                        <button onClick = {e=> {voteDown(idx)}}>Vote down</button>
                                        {/* <button onClick = {e=> {deleteQuote(idx)}}>Delete</button> */}
                                    </td>
                                </tr>
                            )
                        }
                    </table>
                </div>
            )}
        </>
    ) // return end
} // function end

export default QuotesList