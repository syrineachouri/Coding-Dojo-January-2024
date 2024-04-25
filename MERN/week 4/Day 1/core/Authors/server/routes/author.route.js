const AuthorController = require('../controllers/author.controller');

module.exports=(app)=>{
    app.get('/api/author',AuthorController.FindAll);
    app.post('/api/author/new',AuthorController.create);
    app.patch('/api/author/:id',AuthorController.update);
    app.get('/api/author/:id',AuthorController.getOne);
    app.delete('/api/author/delete/:id',AuthorController.delete);
}