# Update the User class __init__ method

# Update the User class make_deposit method

# Update the User class make_withdrawal method

# Update the User class display_user_balance method

class bankAcct:
    def __init__(self, name, bal = 0, int_rate = .02):
        self.name = None
        self.acct_bal = bal
        self.interest = int_rate
    #end of init def

class user:
    def __init__(self, name, acct_name, acct_bal = 0):
        global acct_list
        acct_list = {}
        self.name = name
        self.acct = bankAcct(name = acct_name)
        self.acct_list = {acct_name : acct_bal}
    #end of init def

    def assignAcct(self, acct_name, acct_bal = 0):
        self.acct_list[acct_name] = acct_bal
        return self
    #end of assign account def

    def deposit(self, acct_name, amt):
        self.acct_list[acct_name] += amt
        return self
    #end of deposit def

    def withdraw(self, acct_name, amt):
        self.acct_list[acct_name] -= amt
        return self
    #end of withdraw def

    def display_user_bal(self):
        print(self.name+"'s accounts:", self.acct_list)
        return self
    #end of display user balance def

    def yield_int(self, acct_name):
        self.acct_list[acct_name] += (self.acct_list[acct_name]*self.acct.interest)
        return self
    #end of yield interest def

# Create 2 accounts
bob = user("Bob", "checking")
charles = user("Charles", "checking")
charles.assignAcct("credit")

# To the first account, make 3 deposits and 1 withdrawal, then yield interest and display the account's info all in one line of code (i.e. chaining)
bob.deposit("checking", 500).deposit("checking", 1000).deposit("checking", 700).withdraw("checking", 1200).yield_int("checking").display_user_bal()

# To the second account, make 2 deposits and 4 withdrawals, then yield interest and display the account's info all in one line of code (i.e. chaining)
charles.deposit("checking", 1000).deposit("checking", 3000).withdraw("checking", 500).withdraw("checking", 200).withdraw("checking", 1000).withdraw("checking", 500).yield_int("checking").display_user_bal()

# SENSEI BONUS: Allow a user to have multiple accounts; update methods so the user has to specify which account they are withdrawing or depositing to
charles.deposit("credit", 1000).deposit("credit", 3000).display_user_bal()