from flask_app import app
from flask import render_template, redirect, request, session
from flask_app.models.ninja import Ninja
from flask_app.models.dojo import Dojo

@app.route("/success")
def success():
    print(request.form)
    Dojo.save(request.form)
    return redirect("/dojos")

@app.route("/dojos")
def dojos():
    dojos = Dojo.get_all()
    return render_template("dojo.html", dojos = dojos)

@app.route("/success2", methods = ["POST"])
def success2():
    print(request.form)
    Ninja.save(request.form)
    return redirect("/dojos")

@app.route("/ninjas")
def ninjas():
    dojos = Dojo.get_all()
    return render_template("ninja.html", dojos = dojos )

@app.route("/dojo/<int:id>")
def dojos_ninjas(id):
    data = {
        "id": id
    }
    dojo = Dojo.dojos_with_ninjas(data)
    return render_template("index.html", dojo = dojo )
