const {createJoke, getAllJokes, getOneJoke, updateJoke, deleteJoke} = require('../controllers/controller');

module.exports = app => {
    // create
    app.post('/api/jokes/new', createJoke);

    // read
    app.get('/api/jokes', getAllJokes);
    app.get('/api/jokes/:id', getOneJoke);
    // app.get('/api/jokes/random', getRanJoke);

    // update
    app.put('/api/jokes/:id', updateJoke);

    // delete
    app.delete('/api/jokes/:id', deleteJoke);
}