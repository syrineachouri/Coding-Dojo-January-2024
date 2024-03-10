from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash
from flask_app import app
import re 
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
NAME_REGEX = re.compile(r'^[a-zA-Z]')

class User:
    def __init__(self,data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.password = data['password']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        
    @classmethod
    def save(cls, data ):
        query = "INSERT INTO users ( first_name , last_name , email , password, created_at, updated_at ) VALUES ( %(first_name)s , %(last_name)s , %(email)s , %(password)s, NOW() , NOW() );"
        # data is a dictionary that will be passed into the save method from server.py
        return connectToMySQL('login_schema').query_db( query, data ) 
    @classmethod 
    def get_all(cls) : 
        query = "SELECT * FROM users;"
        results = connectToMySQL('login_schema').query_db(query)
        users = []
        for u in results :
            users.append(cls(u))
        return users
    @classmethod
    def get_by_email(cls,data):
        query = "SELECT * FROM users WHERE email = %(email)s;"
        result = connectToMySQL('login_schema').query_db(query,data)
        if len(result) < 1:
            return False
        return cls(result[0])
    @classmethod
    def get_by_id(cls, data):
        query = "SELECT * FROM users WHERE id = %(id)s"
        results = connectToMySQL('login_schema').query_db(quersy, data)
        return cls(results[0])
    @staticmethod 
    def is_valid(data) : 
        is_valid = True
        query = "SELECT * FROM users WHERE email = %(email)s;"
        results = connectToMySQL('login_schema').query_db(query)
        if len("results") >=1 :
            flash("Email already  taken")
            is_valid = False
        if len(data["first_name"]) > 2 :
            flash("First Name and Last Name should be at leat 2 charachters")
            is_valid = False
        if len(data["last_name"]) > 2 :
            flash("First Name and Last Name should be at leat 2 charachters")
            is_valid = False
        if not NAME_REGEX.match(data["first_name"]) : 
            flash("The first and Last name should be only charachters")
            is_valid = False
        if not NAME_REGEX.match(data["last_name"]) :
            flash("The first and Last name should be only charachters")
            is_valid = False
        if not EMAIL_REGEX.match(data["email"]) : 
            flash("The email you entered is not valid please try again")
            is_valid = False
        if data["password"] != data["password-c"] :
            flash("passwords dont match")
            is_valid = False
        if len(data["password"]) <= 8 :
            flash("password too short")
            is_valid = False
        return is_valid