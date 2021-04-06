# Create a file with the User class, including the __init__ and make_deposit methods

# Add a make_withdrawal method to the User class

# Add a display_user_balance method to the User class

class user:
    def __init__(self, name):
        self.name = name
        self.acct_bal = 0
    #end of init def

    def deposit(self, amt):
        self.acct_bal += amt
    #end of deposit def

    def withdraw(self, amt):
        self.acct_bal -= amt
    #end of withdraw def

    def display_user_bal(self):
        print(str(self.name)+"'s account balance:", self.acct_bal)
    #end of display user balance def

    def transfer_bal(self, target, amt):
        self.acct_bal -= amt
        target.acct_bal += amt
        print(str(self.name)+"'s account balance:", self.acct_bal)
        print(str(target.name)+"'s account balance:", target.acct_bal)
    #end of transfer bal def
#end of user class

# Create 3 instances of the User class
bob = user("Bob Jacobs")
charles = user("Charles Teng")
ying = user("Ying Vuong")

# Have the first user make 3 deposits and 1 withdrawal and then display their balance
bob.deposit(1000)
bob.deposit(2000)
bob.deposit(500) #total: 3500
bob.withdraw(300) #total: 3200
bob.display_user_bal()

# Have the second user make 2 deposits and 2 withdrawals and then display their balance
charles.deposit(5000)
charles.deposit(2000) #total: 7000
charles.withdraw(1000)
charles.withdraw(1500) #total: 4500
charles.display_user_bal()

# Have the third user make 1 deposits and 3 withdrawals and then display their balance
ying.deposit(4000)
ying.withdraw(500) #total: 4500
ying.withdraw(1000)
ying.withdraw(250) #total: 2250
ying.display_user_bal()

# BONUS: Add a transfer_money method; have the first user transfer money to the third user and then print both users' balances
print("Transfering balance...")
bob.transfer_bal(ying, 2500)