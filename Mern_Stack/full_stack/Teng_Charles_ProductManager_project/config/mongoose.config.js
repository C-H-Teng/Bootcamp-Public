const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost/managerdb', {
    useNewUrlParser: true,
    useUnifiedTopology: true
})
    .then(() => console.log("DB connection established"))
    .catch(err => console.log("Database connection error:", err));