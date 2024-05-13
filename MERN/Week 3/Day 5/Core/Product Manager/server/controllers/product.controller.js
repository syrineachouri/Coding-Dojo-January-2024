const {Product} = require("../models/product.model");


module.exports.FindAll=(req,res)=>{
    Product.find({})
    .then ((obj=>res.json(obj)))
    .catch(err=> res.json(err))
};

// CREATE 
module.exports.create=(req,res)=>{
    Product.create(req.body)
    .then ((obj=>res.json(obj)))
    .catch(err=> res.status(400).json(err))
};

// UPDATE
module.exports.update=(req,res)=>{
    Product.findOneAndUpdate({_id:req.params.id},req.body,{new:true, runValidators:true})
    .then ((obj=>res.json(obj)))
    .catch(err=> res.status(400).json(err))
};

// get one 
module.exports.getOne=(req,res)=>{
    Product.findOne({_id:req.params.id})
    .then ((obj=>res.json(obj)))
    .catch(err=> res.json(err))
};

// DELETE
module.exports.delete=(req,res)=>{
    Product.deleteOne({_id:req.params.id})
    .then ((obj=>res.json(obj)))
    .catch(err=> res.json(err))
};


