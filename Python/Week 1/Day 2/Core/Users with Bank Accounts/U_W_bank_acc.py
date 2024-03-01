from bankaccount import bankaccount


class User:
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account = bankaccount(int_rate=0.09, balance=0)


    
    def make_deposit(self, amount):
        self.account.deposit(amount).display_account_info()



    def make_withdrawal (self,amount):
        self.account.withdraw(amount)

    
    def  display_user_balance(self):
        self.account.display_account_info()