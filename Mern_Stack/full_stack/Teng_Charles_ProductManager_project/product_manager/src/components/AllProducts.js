import React, {useEffect} from 'react';
import axios from 'axios';
import {Link} from '@reach/router';

const AllProducts = props => {
    const {productsList, setProductsList, removeFromDom} = props;

    useEffect(() => {
        axios.get('http://localhost:8000/api/products')
            .then(response => setProductsList(response.data.data))
            .catch(err => console.log(err));
    }, [])

    const deleteProduct = (productID) => {
        axios.delete(`http://localhost:8000/api/products/${productID}`)
            .then(res => {removeFromDom(productID)});
    }

    console.log("products list test")


    return (
        <div className="container">
            <h2>All Products</h2>
            {
                productsList.map( (product, idx) => 
                    <div className="prodRow" key={idx}>
                        <h4><Link to={`/${product._id}`}>{product.productName}</Link></h4>
                        <button onClick = {e => {deleteProduct(product._id)}}>Delete</button>
                    </div>
                )
            }
        </div>
    ) // return end
} // function end

export default AllProducts