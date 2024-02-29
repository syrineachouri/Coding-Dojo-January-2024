class Users :

    def __init__(self, first_name, last_name, email, age ):
        self.first_name=first_name
        self.last_name=last_name
        self.email=email
        self.age=age
        self.is_rewards_member = False
        self.gold_card_points = 0


    def display_info(self):
        print(f"{self.first_name} {self.last_name} {self.email} {self.age}")
        return self
    

    def enroll(self):
        self.is_rewards_member=True
        self.gold_card_points=350
        return self
    

    def spend_points(self, amount):
        self.gold_card_points-=amount
        return self
    
person = Users("zayn","malik","zaynm@gmail.com",28)
person_1 = Users("rachel","green","rechel@gmail.com",22)
person_2 = Users("harry","styles","harrystyles@gmail.com",43)

person.display_info().enroll().spend_points(45).display_info()
person_1.enroll().spend_points(56).display_info()
person_2.enroll().spend_points(72).display_info()


print(person.gold_card_points)
print(person_1.gold_card_points)
print(person_2.is_rewards_member)