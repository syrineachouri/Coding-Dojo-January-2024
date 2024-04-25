const mongoose = require('mongoose');

const JokeSchema = new mongoose.Schema({
    setup: {
        type: String,
        required: true,
        minlength: [10, "setup must be at least 10 charachters"],
    },
    punchline: {
        type: String,
        required: true,
        minlength: [3, "Punchline must be at least 10 charachters"],
    }
});



module.exports.Joke = mongoose.model('Joke', JokeSchema);