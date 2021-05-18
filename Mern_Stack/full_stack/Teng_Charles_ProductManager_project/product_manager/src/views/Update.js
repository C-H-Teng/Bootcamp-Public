import React, {useEffect, useState} from 'react';
import axios from 'axios';
import {Navigate} from '@reach/router';

const Update = props => {
    const {id} = props;
    const [productName, setProductName] = useState("");
    const [price, setPrice] = useState("");
    const [description, setDescription] = useState("");


    useEffect(() => {
        axios.get(`http://localhost:8000/api/products/${id}`)
            .then(res => {
                setProductName(res.data.data.productName);
                setPrice(res.data.data.price);
                setDescription(res.data.data.description);
            })
    }, [])

    const updateProduct = e => {
        e.preventDefault();
        axios.put(`http://localhost:8000/api/products/${id}`, {
            productName,
            price,
            description
        })
            .then(res => {
                console.log(res);
                window.location = "/";
            });
    }

    console.log("update test");


    return(
        <div className="container">
            <h1>Update Product:</h1>
            <form onSubmit={updateProduct}>
                <div class="row">
                    <label htmlFor="productName">Product Name:</label>
                    <input type="text" onChange={e => setProductName(e.target.value)} name="productName" value={productName} />
                </div>
                <div class="row">
                    <label htmlFor="productPrice">Product Price:</label>
                    <input type="text" onChange={e => setPrice(e.target.value)}     name="productPrice" value={price} />
                </div>
                <div class="row">
                    <label htmlFor="productDesc">Product Description:</label>
                    <input type="text" onChange={e => setDescription(e.target.value)} name="productDescription" value={description} />
                </div>
                <div>
                    <button type="submit" value="submit">Submit Product</button>
                </div>
            </form>
        </div>
    ) // return end
} // function end

export default Update