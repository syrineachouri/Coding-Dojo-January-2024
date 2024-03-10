from flask_app.config.mysqlconnection import connectToMySQL
# model the class after the friend table from our database
class User:
    def __init__( self , data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
    # Now we use class methods to query our database
    @classmethod
    def get_all(cls):
        query = "SELECT * FROM users;"
        results = connectToMySQL('users_schema').query_db(query)
        users = []
        for u in results :
            users.append( cls(u) )
        return users
    @classmethod
    def save(cls, data) : 
        query = "INSERT INTO users (first_name, last_name, email, created_at, updated_at) VALUES (%(fname)s, %(lname)s, %(email)s, NOW(), NOW());"
        return connectToMySQL("users_schema").query_db(query, data)
    @classmethod
    def get_id(cls, data) : 
        query = "SELECT * FROM users WHERE id = %(id)s; "
        result = connectToMySQL('users_schema').query_db(query, data)
        return cls(result[0])
    
    @classmethod
    def delete_id(cls, data) : 
        query = "DELETE FROM users WHERE id = %(id)s;"
        return connectToMySQL('users_schema').query_db(query, data)
    
    @classmethod
    def update_id(cls, data):
        query ="UPDATE users SET first_name=%(fname)s, last_name=%(lname)s, email=%(email)s, created_at=NOW(), updated_at = Now() WHERE id = %(id)s;"
        return connectToMySQL('users_schema').query_db(query, data)
    