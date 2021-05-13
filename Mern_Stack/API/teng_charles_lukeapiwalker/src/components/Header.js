import React, {useState} from 'react';
import {navigate} from '@reach/router';


const Header = props => {
    const [category, setCategory] = useState("people");
    const [categoryID, setCategoryID] = useState("");

    const searchHandler = e => {
        // e.preventDefault();
        // console.log(category);
        // console.log(categoryID);

        if(isNaN(categoryID) || categoryID === null){
            alert("Please enter a number.");
        } else {
            navigate(`/${category}/${categoryID}`)
        }

        // setCategoryID("");
    }

    return (
        <div>
            <form onSubmit={searchHandler}>
                <select onChange={e => setCategory(e.target.value)}>
                    <option name="catName" value="people">People</option>
                    <option name="catName" value="planets">Planets</option>
                </select>
                <label htmlFor="catID">Category ID: </label>
                <input type="integer" name="catID" onChange={e => setCategoryID(e.target.value)} value={categoryID} />
                <button type="submit" value="submit">Search</button>
            </form>
        </div>
    )
}

export default Header