from flask_app import app
from flask import render_template, redirect, request, session, flash
from flask_app.models.user import User


#the create user route
@app.route("/create")
def index():
    return render_template("create.html")

#the success route that redirects to display route
@app.route("/success", methods=["POST"])
def success():
    data = {
        "fname" : request.form["fname"],
        "lname" : request.form["lname"],
        "email" : request.form["email"]
    }
    User.save(data)
    return redirect("/display")

#the display route
@app.route("/display")
def display() :  
    users = User.get_all()
    return render_template("display.html", users = users)

#the info about user page route
@app.route("/read/<int:id>")
def read(id):
    data = {
        "id" : id
    }
    user = User.get_id(data)
    return render_template("read.html", user = user)


#the edit route
@app.route("/edit/<int:id>")
def edit(id):
    data = {
        "id":id
    }
    user = User.get_id(data)
    return render_template("edit.html", user = user)

#the delete route
@app.route("/delete/<int:id>")
def delete(id):
    data = {
        "id":id
    }
    User.delete_id(data)
    return redirect("/display")

#the update route
@app.route("/update", methods =["POST"])
def update():
    User.update_id(request.form)
    return redirect("/display")
