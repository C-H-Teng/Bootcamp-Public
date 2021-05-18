const {createProduct, getAllProducts, getOneProduct, updateProduct, deleteProduct} = require('../controllers/controller');

module.exports = app => {
    app.post('/api/products/new', createProduct);

    app.get('/api/products', getAllProducts);
    app.get('/api/products/:id', getOneProduct);

    app.put('/api/products/:id/', updateProduct);

    app.delete('/api/products/:id', deleteProduct);
}