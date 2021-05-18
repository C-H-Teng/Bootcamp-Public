const Product = require('../models/model');

module.exports = {
    // create
    createProduct: (req, res) => {
        Product.create(req.body)
        .then(result => res.json({message: "success", data: result}))
        .catch(err => res.json({message: "error", error: err}))
    },

    // read
    getAllProducts: (req, res) => {
        Product.find({})
            .then(result => res.json({message: "success", data: result}))
            .catch(err => res.json({message: "error", error: err}))
    },
    getOneProduct: (req, res) => {
        Product.findById({_id: req.params.id})
            .then(result => res.json({message: "success", data: result}))
            .catch(err => res.json({message: "error", error: err}))
    },
    
    // update
    updateProduct: (req, res) => {
        Product.findByIdAndUpdate({_id: req.params.id}, req.body, {new: true, runValidators: true})
            .then(result => res.json({message: "success", data: result}))
            .catch(err => res.json({message: "error", error: err}))
    },
    
    // delete
    deleteProduct: (req, res) => {
        Product.findByIdAndDelete({_id: req.params.id})
            .then(result => res.json({message: "success", data: result}))
            // .then(deleteConfirm => res.json(deleteConfirm))
            .catch(err => res.json({message: "error", error: err}))
    }
}