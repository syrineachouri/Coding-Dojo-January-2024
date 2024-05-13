const ProductController = require('../controllers/product.controller');

module.exports=(app)=>{
    app.get('/api/product',ProductController.FindAll);
    app.post('/api/product/new',ProductController.create);
    app.patch('/api/product/:id',ProductController.update);
    app.get('/api/product/:id',ProductController.getOne);
    app.delete('/api/product/delete/:id',ProductController.delete);
}