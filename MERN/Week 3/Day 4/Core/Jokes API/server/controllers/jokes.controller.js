const { Joke } = require("../models/jokes.model")

module.exports.findAll = (req, res) => {
    Joke.find({})
        .then((obj) => res.json(obj))
        .catch((err) => res.json(err));
}

module.exports.create = (req, res) => {
    Joke.create(req.body)
        .then((obj) => res.json(obj))
        .catch((err) => res.status(400).json(err));
}

module.exports.update = (req, res) => {
    Joke.findOneAndUpdate({ _id: req.params.id }, req.body, { new: true, runValidators: true })
        .then((obj) => res.json(obj))
        .catch((err) => res.status(400).json(err));
}

module.exports.getOne = (req, res) => {
    Joke.findOne({ _id: req.params.id })
        .then((obj) => res.json(obj))
        .catch((err) => res.json(err));
}

module.exports.delete = (req, res) => {
    Joke.deleteOne({ _id: req.params.id })
        .then(obj => res.json(obj))
        .catch((err) => res.json(err));
};