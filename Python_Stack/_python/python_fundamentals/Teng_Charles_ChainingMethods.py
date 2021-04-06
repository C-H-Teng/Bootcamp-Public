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
        return self
    #end of deposit def

    def withdraw(self, amt):
        self.acct_bal -= amt
        return self
    #end of withdraw def

    def display_user_bal(self):
        print(str(self.name)+"'s account balance:", self.acct_bal)
        return self
    #end of display user balance def

    def transfer_bal(self, target, amt):
        self.acct_bal -= amt
        target.acct_bal += amt
        print(str(self.name)+"'s account balance:", self.acct_bal)
        print(str(target.name)+"'s account balance:", target.acct_bal)
        return self
    #end of transfer bal def
#end of user class

# Create 3 instances of the User class
bob = user("Bob Jacobs")
charles = user("Charles Teng")
ying = user("Ying Vuong")

# Have the first user make 3 deposits and 1 withdrawal and then display their balance
bob.deposit(1000).deposit(2000).deposit(500).withdraw(300).display_user_bal()

# Have the second user make 2 deposits and 2 withdrawals and then display their balance
charles.deposit(5000).deposit(2000).withdraw(1000).withdraw(1500).display_user_bal()

# Have the third user make 1 deposits and 3 withdrawals and then display their balance
ying.deposit(4000).withdraw(500).withdraw(1000).withdraw(250).display_user_bal()

# BONUS: Add a transfer_money method; have the first user transfer money to the third user and then print both users' balances
print("Transferring balance...")
bob.transfer_bal(ying, 2500)