const mongoose = require('mongoose');

// schema: rules that entries in the database must follow
const JokeSchema = new mongoose.Schema({
    setup: {
        type: String,
        required: [true, "Setup for the joke is required"],
        minlength: [10, "Setup needs to be at least 10 characters long"]
    },
    punchline: {
        type: String,
        required: [true, "There must be a punchline for the joke"],
        minlength: [3, "There must be at least 3 characters for the punchline"]
    }
}, {timestamps: true})

// model: used to make actual queries to DB
const Joke = mongoose.model("Joke", JokeSchema);

module.exports = Joke;