# Update the User class __init__ method

# Update the User class make_deposit method

# Update the User class make_withdrawal method

# Update the User class display_user_balance method

class bankAcct:
    def __init__(self, owner, acct_type = "checking", bal = 0, int_rate = .02):
        self.name = owner
        self.acct_list = {owner : acct_type}
        self.acct_bal = bal
        self.interest = int_rate
    #end of init def

    def deposit(self, acct_name, amt):
        self.acct_bal += amt
        return self
    #end of deposit def

    def withdraw(self, acct_name, amt):
        self.acct_bal -= amt
        return self
    #end of withdraw def

    def display_user_bal(self, acct_type = "checking"):
        print(self.name+"'s", acct_type, "account:", self.acct_bal)
    #end of display user balance def

    def yield_int(self, acct_type):
        self.acct_bal += (self.acct_bal * self.interest)
        return self
    #end of yield interest def

class user:
    def __init__(self, name, acct_type = "checking", acct_bal = 0):
        self.name = name
        self.acct_list = {
            "checking" : bankAcct(name)
        }
    #end of init def

    def assignAcct(self, owner, acct_type, acct_bal = 0):
        self.acct_list[acct_type] = bankAcct(owner, acct_type)
        return self
    #end of assign account def

    def deposit(self, acct_name, amt):
        self.acct_list[acct_name].deposit(acct_name, amt)
        return self
    #end of deposit def

    def withdraw(self, acct_name, amt):
        self.acct_list[acct_name].withdraw(acct_name, amt)
        return self
    #end of withdraw def

    def display_user_bal(self, acct_name = "checking"):
        self.acct_list[acct_name].display_user_bal(acct_name)
        return self
    #end of display user balance def

    def yield_int(self, acct_type):
        self.acct_list[acct_type].yield_int(acct_type)
        return self
    #end of yield interest def

    def transfer_bal(self, acct_name, target, target_acct_name, amt):
        self.acct_list[acct_name].withdraw(acct_name, amt)
        target.acct_list[target_acct_name].deposit(target_acct_name, amt)
        return self

# Create 2 accounts
bob = user("Bob", "checking")
charles = user("Charles", "checking")
charles.assignAcct("Charles", "credit")

# To the first account, make 3 deposits and 1 withdrawal, then yield interest and display the account's info all in one line of code (i.e. chaining)
bob.deposit("checking", 500).deposit("checking", 1000).deposit("checking", 700).withdraw("checking", 1200).yield_int("checking").display_user_bal()

# To the second account, make 2 deposits and 4 withdrawals, then yield interest and display the account's info all in one line of code (i.e. chaining)
charles.deposit("checking", 1000).deposit("checking", 3000).withdraw("checking", 500).withdraw("checking", 200).withdraw("checking", 1000).withdraw("checking", 500).yield_int("checking").display_user_bal().transfer_bal("checking", bob, "checking", 500)
charles.display_user_bal()
bob.display_user_bal()

# SENSEI BONUS: Allow a user to have multiple accounts; update methods so the user has to specify which account they are withdrawing or depositing to
charles.deposit("credit", 1000).deposit("credit", 3000).yield_int("credit").display_user_bal("credit")