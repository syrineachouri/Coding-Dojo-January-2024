from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash
import re
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

class Recipe:
    def __init__(self,data):
        self.id = data["id"]
        self.name = data["name"]
        self.description = data["description"]
        self.under_30 = data["under_30"]
        self.instructions = data["instructions"]
        self.date_made = data["date_made"]
        self.user_id = data["user_id"]
        # self.created_at = data["created_at"]
        # self.updated_at = data["updated_at"]

    @staticmethod
    def validate_recipe(recipe):
        is_valid = True
        return is_valid

    @classmethod
    def save(cls, data):
        query = "INSERT INTO recipes (name, description, under_30, instructions, date_made, user_id) VALUES (%(name)s, %(description)s, %(under_30)s, %(instructions)s, %(date_made)s, %(user_id)s);"
        return connectToMySQL('recipes_schema').query_db(query,data)
    
    @classmethod
    def get_by_id(cls,data):
        query = "SELECT * FROM recipes WHERE id = %(id)s;"
        results =  connectToMySQL('recipes_schema').query_db(query,data)
        return cls(results[0])
