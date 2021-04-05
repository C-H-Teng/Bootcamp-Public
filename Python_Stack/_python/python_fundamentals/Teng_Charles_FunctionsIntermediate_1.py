# With this concept of default parameters in mind, the goal of this assignment is to write a single function, randInt() that takes up to 2 arguments.

#     If no arguments are provided, the function should return a random integer between 0 and 100.
#     If only a max number is provided, the function should return a random integer between 0 and the max number.
#     If only a min number is provided, the function should return a random integer between the min number and 100
#     If both a min and max number are provided, the function should return a random integer between those 2 values.
#     BONUS: account for any edge cases (eg. min > max, max < 0)

import random
def randInt(min=0, max=100):
    num = random.random()
    if(max < min): #sets max to min+1
        max = min + 1
        print("Setting max to", max)
    #end of if statement
    if(max < 0):
        max = 1
    #end of if statement
    num = num * max + min
    if(num > max):
        num = max
    #end of if statement
    if(num < min):
        num = min
    #end of if statement
    return int(num)
#end of def

print("0-100:", randInt()) 		    # should print a random integer between 0 to 100
print("0-50:", randInt(max=50)) 	    # should print a random integer between 0 to 50
print("50-100:", randInt(min=50)) 	    # should print a random integer between 50 to 100
print("50-500:", randInt(min=50, max=500))    # should print a random integer between 50 and 500
print("50-51:", randInt(min=50, max=51))
print("Min=51, max=25:", randInt(min=51, max=25))