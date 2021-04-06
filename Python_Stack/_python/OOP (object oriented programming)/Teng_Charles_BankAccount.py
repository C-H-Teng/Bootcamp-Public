# Create a BankAccount class with the attributes interest rate and balance

# Add a deposit method to the BankAccount class

# Add a withdraw method to the BankAccount class

# Add a display_account_info method to the BankAccount class

# Add a yield_interest method to the BankAccount class

class bankAcct:
    def __init__(self, name, bal, int_rate):
        self.name = name
        self.acct_bal = bal
        self.interest = int_rate
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

    def yield_int(self):
        self.acct_bal += (self.acct_bal*self.interest)
        return self
    #end of yield interest def

# Create 2 accounts
bob = bankAcct("Bob", 5000, .01)
charles = bankAcct("Charles", 5000, .05)

# To the first account, make 3 deposits and 1 withdrawal, then yield interest and display the account's info all in one line of code (i.e. chaining)
bob.deposit(500).deposit(1000).deposit(700).withdraw(1200).yield_int().display_user_bal()

# To the second account, make 2 deposits and 4 withdrawals, then yield interest and display the account's info all in one line of code (i.e. chaining)
charles.deposit(1000).deposit(3000).withdraw(500).withdraw(200).withdraw(1000).withdraw(1300).yield_int().display_user_bal()