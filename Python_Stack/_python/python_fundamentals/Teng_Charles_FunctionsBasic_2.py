# 1. Countdown - Create a function that accepts a number as an input. Return a new list that counts down by one, from the number (as the 0th element) down to 0 (as the last element).
#     Example: countdown(5) should return [5,4,3,2,1,0]
def countdown(x):
    cd_list = []
    for x in range(x, -1, -1):
        cd_list.append(x)
    #End of for loop
    return cd_list
#End of def
print(countdown(10))
print("End of question 1")

# 2. Print and Return - Create a function that will receive a list with two numbers. Print the first value and return the second.
#     Example: print_and_return([1,2]) should print 1 and return 2
def printNReturn(a,b):
    print("Printed value:", a)
    return(b)
#end of def
print("Returned value:", printNReturn(4,8))
print("End of question 2")

# 3. First Plus Length - Create a function that accepts a list and returns the sum of the first value in the list plus the list's length.
#     Example: first_plus_length([1,2,3,4,5]) should return 6 (first value: 1 + length: 5)
def firstPlusLen(a):
    sum = a[0] + len(a)
    return sum
# end of def
print("Sum of first value and length:", firstPlusLen([1,2,3,4,5]))
print("End of question 3")

# 4. Values Greater than Second - Write a function that accepts a list and creates a new list containing only the values from the original list that are greater than its 2nd value. Print how many values this is and then return the new list. If the list has less than 2 elements, have the function return False
#     Example: values_greater_than_second([5,2,3,2,1,4]) should print 3 and return [5,3,4]
#     Example: values_greater_than_second([3]) should return False
def grtrSec(y):
    newList = []
    countY = 0
    if(len(y) >= 2):
        for x in range(0, len(y), 1):
            if(y[x] > y[1]):
                newList.append(y[x])
                countY += 1
            # end of if statement
        #end of for statement
        print("Numbers greater than", str(y[1])+":", countY)
        return newList
    #end of if statement
    else:
        return "False"
    #end of else statement
#end of def
print("List of larger numbers:", grtrSec([5,4,3,2,1,4,8,6]))
print("End of question 4")

# 5. This Length, That Value - Write a function that accepts two integers as parameters: size and value. The function should create and return a list whose length is equal to the given size, and whose values are all the given value.
#     Example: length_and_value(4,7) should return [7,7,7,7]
#     Example: length_and_value(6,2) should return [2,2,2,2,2,2]
def lenNVal(s,v):
    newList = []
    for x in range(0, s+1, 1):
        newList.append(v)
    #end of for loop
    return newList
# End of def
print(lenNVal(5,10))
print("End of question 5")