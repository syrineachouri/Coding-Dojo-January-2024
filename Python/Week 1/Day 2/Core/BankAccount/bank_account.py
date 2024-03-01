class bankaccount:

    accounts=[]
    def __init__(self, int_rate, balance=0): 
        self.int_rate=int_rate
        self.balance=balance
        bankaccount.accounts.append(self)

    def deposit(self, amount):
        self.balance+=amount
        return self
    
    def withdraw(self, amount):
        self.balance-=amount
        return self
    
    def display_account_info(self):
        print(f"balance : ${self.balance}")
    
    def yield_interest(self):
        if bankaccount.can_yield_interest(self.balance):
            self.balance+=self.balance*self.int_rate
        return self
        
    @staticmethod
    def can_yield_interest(balance):
        if balance > 0 :
            return True
        else :
            return False
    @classmethod
    def all_instances(cls):
        for account in cls.accounts:
            print(f"int_rate : {account.int_rate} , balance : {account.balance}")

person_1=bankaccount(0.06,800)
person_2=bankaccount(0.09,700)

bankaccount.all_instances()
person_1.deposit(50).deposit(50).deposit(50).withdraw(80).yield_interest().display_account_info()
person_2.deposit(70).deposit(70).withdraw(70).withdraw(40).withdraw(70).withdraw(45).yield_interest().display_account_info()                  
bankaccount.all_instances()

