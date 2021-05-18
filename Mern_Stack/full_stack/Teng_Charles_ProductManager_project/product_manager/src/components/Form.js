import React, {useState} from 'react';
import axios from 'axios';


const Form = props => {
    const {submitProduct} = props;
    const [productName, setProductName] = useState("");
    const [price, setPrice] = useState("");
    const [description, setDescription] = useState("");

    const submitHandler = e => {
        e.preventDefault();
        axios.post('http://localhost:8000/api/products/new', {
            productName,
            price,
            description
        }) // post line end
            .then(res => {
                console.log(res);
                submitProduct(res.data);
            })
            .catch(err => console.log(err));

        setProductName("");
        setPrice("");
        setDescription("");
    }

    console.log("form test")

    return (
        <div className="container">
            <form onSubmit={submitHandler}>
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

            <hr />
        </div>
    ); // return end
}

export default Form