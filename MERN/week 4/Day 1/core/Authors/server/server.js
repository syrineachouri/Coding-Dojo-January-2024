const express = require("express");
const app = express();
const cors = require("cors");
require ("dotenv").config();
const port = process.env.port;


// === MIDDLEWARE === 
app.use(express.json(),express.urlencoded({extended:true}),cors());
// grab the config
require("./config/mongoose.config");
//  grab the routes 
require("./routes/author.route")(app);
app.listen(port,()=>{console.log("listening to port" +port);
});