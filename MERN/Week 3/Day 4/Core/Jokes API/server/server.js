const express = require("express")
const app = express()

app.use(express.json(), express.urlencoded({ extended: true }));


require("dotenv").config()

require("./config/mongoose.config")
const PORT = process.env.PORT

require("./routes/jokes.route")(app)

app.listen(PORT, () => {
    console.log(`Connecting to our server with success to this PORT : ${PORT}`)
})