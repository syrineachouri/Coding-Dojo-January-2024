const mongoose = require('mongoose');

const AuthorSchema = new mongoose.Schema({
    name:{
        type:String,
        required:[true,"{PATH} is required"],
        minlength:[1,"{PATH} must be a least three characters"]
    },
},{timestamps:true});

module.exports.Author=mongoose.model('Author',AuthorSchema);