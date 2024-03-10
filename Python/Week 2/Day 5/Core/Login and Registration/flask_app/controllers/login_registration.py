from flask_app import app
from flask import render_template, redirect, request, session, flash
from flask_app.models.user import User

@app.route('/')
def index():
    return  render_template("index.html")

@app.route("/register", methods = ["POST"])
def register():
    if not User.is_valid(request.form):
        return redirect("/")
    data = {
        "first_name" : request.form['first_name'],
        "last_name" : request.form['last_name'],
        "email" : request.form['email'],
        "password" : bcrypt.generate_password_hash(request.form['password'])
                }
    id = User.save(data)
    session['user_id'] = id
    return redirect("/success")

@app.route("/login", methods = ["POST"])
def login():
    user = User.get_by_email(request.form)
    if not user : 
        flash("invalid email")
        return redirect("/")
    if not bcrypt.check_password_hash(user.password, request.form):
        flash("password incorrect")
        return redirect("/")
    return redirect("/success")

@app.route("/success")
def success():
    if "user.id" not in session : 
        return redirect("/")
    data = {
        "id" : session['user_id']
    }
    user = User.get_by_id(data)
    return render_template("dashboard.html", user = user)

@app.route("/logout")
def logout():
    session.clear()
    return redirect("/")