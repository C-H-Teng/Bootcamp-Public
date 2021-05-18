const mongoose = require('mongoose');

const ProductManagerSchema = new mongoose.Schema({
    productName: {
        type: String,
        required: [true, "Name of the product is required."],
        minlength: [2, "Surely, you could come up with a better name."]
    },
    price : {
        type: Number,
        required: [true, "Price of the product is required."]
    },
    description: {
        type: String,
        required: [true, "Surely, you can describe your product."],
        minlength: [10, "A child can describe this better than you."]
    }
}, {timestamps: true})

const Product = mongoose.model("Product", ProductManagerSchema);

module.exports = Product;