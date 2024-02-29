class User:
    def __init__(self, first_name, last_name, email, age, is_rewards_member=False, gold_card_points=0):
        self.first_name = first_name
        self.last_name = last_name
        self.email = email
        self.age = age
        self.is_rewards_member=is_rewards_member
        self.gold_card_points =gold_card_points

    def display_info(self):
        print(f"name: {self.first_name} {self.last_name}\n")
        print(f"email: {self.email}")
        print(f"age: {self.age}")
        print(f"rewards number: {self.is_rewards_member}")
        print(f"gold points: {self.gold_card_points }")
        return
    

    def enroll(self):
        self.rewards_number = True
        self.gold_card_points = 350 
        return
    

    def spend_point(self,amount):
        self.gold_card_points=self.gold_card_points-amount
        return
user_gold=User("lilly","green","lilly@gmail.com",22)
user_gold.display_info().enroll().spend_points(50)



user_silver=User("mila","marwah","milamarwah@gmail.com",26)
user_silver.enroll().spend_points(50).display_info()
user_bronze=User("mariem","doe","mariemdoe@gmail.com",22)
user_bronze.enroll().spend_points(80).display_info()