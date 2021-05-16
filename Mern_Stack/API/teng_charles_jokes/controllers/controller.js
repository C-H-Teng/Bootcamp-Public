const Joke = require('../models/model');

// shell: db.collection_name.create(data)
// mongoose: model_name.create(data)

// const randomID = () => {
//     let idArr = Joke.find().map(x => x._id).toArray();
//     randIdx = Math.floor(Math.random() * (idArr.length + 1));
//     return "60a064d539e438764cf53ad0";
//     return idArr[randIdx];
// }


module.exports = {
    // create
    createJoke: (req, res) => {
        Joke.create(req.body)
            .then(result => res.json({message: "success", data: result}))
            .catch(err => res.json({message: "error", error: err}))
    },

    // read
    getAllJokes: (req, res) => {
        Joke.find()
            .then(result => res.json({message: "success", data: result}))
            .catch(err => res.json({message: "error", error: err}))
    },
    getOneJoke: (req, res) => {
        Joke.findById(req.params.id)
            .then(result => res.json({message: "success", data: result}))
            .catch(err => res.json({message: "error", error: err}))
    },
    // getRanJoke: (req, res) => {
    //     Joke.findById(randomID)
    //         .then(result => res.json({message: "success", data: result}))
    //         .catch(err => res.json({message: "error", error: err}))
    // },

    // update
    updateJoke: (req, res) => {
        Joke.findByIdAndUpdate(req.params.id, req.body)
            .then(result => res.json({message: "success", data: result}))
            .catch(err => res.json({message: "error", error: err}))
    },

    // delete
    deleteJoke: (req, res) => {
        Joke.findByIdAndDelete(req.params.id)
        .then(result => res.json({message: "success", data: result}))
        .catch(err => res.json({message: "error", error: err}))
    }
}