from flask_app.config.mysqlconnection import connectToMySQL
from flask_app.models import ninja

class Dojo:
    def __init__(self,db_data):
        self.id = db_data['id']
        self.name = db_data['name']
        self.created_at = db_data['created_at']
        self.updated_at = db_data['updated_at']
        self.ninjas = []
        
    @classmethod
    def save(cls, data ):
        query = "INSERT INTO dojos ( name, created_at, updated_at ) VALUES ( %(name)s, NOW() , NOW() );"
        # data is a dictionary that will be passed into the save method from server.py
        return connectToMySQL('dojos_and_ninjas_schema').query_db( query, data )
    @classmethod
    def dojos_with_ninjas(cls, data):
        query = "SELECT * FROM dojos LEFT JOIN ninjas ON ninjas.dojo_id = dojos.id WHERE dojos.id = %(id)s"
        results = connectToMySQL('dojos_and_ninjas_schema').query_db(query, data)
        dojos = cls(results[0])
        for row_in_db in results : 
            ninja_data = {
                "id": row_in_db["id"],
                "first_name" : row_in_db["first_name"],
                "last_name" : row_in_db["last_name"],
                "age" : row_in_db["age"],
                "created_at" : row_in_db["created_at"],
                "updated_at" : row_in_db["updated_at"]
                }
            dojos.ninjas.append( ninja.Ninja(ninja_data))
        return dojos
    @classmethod
    def get_all(cls) : 
        query = "SELECT * FROM dojos; "
        results = connectToMySQL('dojos_and_ninjas_schema').query_db(query)
        dojos = []
        for d in results :
            dojos.append(cls(d))
        return dojos
