const JokesController = require('../controllers/jokes.controller');
module.exports = (app) => {
    app.get('/api/jokes', JokesController.findAll);
    app.post('/api/jokes/new', JokesController.create);
    app.put('/api/jokes/:id', JokesController.update);
    app.get('/api/jokes/:id', JokesController.getOne);
    app.delete('/api/jokes/:id', JokesController.delete);
}