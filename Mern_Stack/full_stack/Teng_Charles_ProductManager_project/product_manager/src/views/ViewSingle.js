import React, {useState, useEffect} from 'react';
import {Link} from '@reach/router';
import axios from 'axios';

const ViewSingle = props => {
    const {id} = props;
    const [product, setProduct] = useState({});
    const [loaded, setLoaded] = useState(false);

    useEffect(() => {
        axios.get(`http://localhost:8000/api/products/${id}`)
            .then(response => {
                console.log(response.data.data);
                setProduct(response.data.data);
                setLoaded(true);
            })
            .catch(err => console.log(err));
    });

    console.log(product._id)

    return (
            loaded ?
                <div>
                    <h3>{product.productName}</h3>
                    <h4>Price: ${product.price}</h4>
                    <h4>Description: {product.description}</h4>
                    <Link to={`/${id}/edit`}>Edit</Link>
                </div>
                : 
                <div>
                    <h3>Loading</h3>
                </div>
    ) // return end
}

export default ViewSingle