import React, {useState, useEffect} from 'react';
import Form from '../components/Form';
import AllProducts from '../components/AllProducts'
import axios from 'axios';

function Main() {
  const [productsList, setProductsList] = useState([]);
  const [loaded, setLoaded] = useState(false);

  const addProductToList = newProduct => {
    setProductsList([...productsList, newProduct]);
  }

  useEffect(() => {
    axios.get('http://localhost:8000/api/products')
      .then(res => {
        setProductsList(res.data.data);
        setLoaded(true);
      });
  }, [])

  const removeFromDom = productID =>{
    setProductsList(productsList.filter(product => product._id !== productID));
  }

console.log("main test");

  return (
    <div className="App">
      <Form
        submitProduct = {addProductToList}
      />

      {loaded && <AllProducts
        productsList = {productsList}
        setProductsList = {setProductsList}
        removeFromDom = {removeFromDom}
      />}
    </div>
  );
}

export default Main;
