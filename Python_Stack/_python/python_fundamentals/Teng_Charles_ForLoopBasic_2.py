q = 0
def endQuestion():
    global q
    q += 1
    print("End of question", q)
# end of def

# 1. Biggie Size - Given a list, write a function that changes all positive numbers in the list to "big".
#     Example: biggie_size([-1, 3, 5, -5]) returns that same list, but whose values are now [-1, "big", "big", -5]
def posBig(list):
    for x in range(0, len(list), 1):
        if(list[x] > 0):
            list[x] = "big"
        #end of if statement
    #end of for loop
    return list
#end of def
print(posBig([-1, 3, 5, -5]))
endQuestion()

# 2. Count Positives - Given a list of numbers, create a function to replace the last value with the number of positive values. (Note that zero is not considered to be a positive number).
#     Example: count_positives([-1,1,1,1]) changes the original list to [-1,1,1,3] and returns it
#     Example: count_positives([1,6,-4,-2,-7,-2]) changes the list to [1,6,-4,-2,-7,2] and returns it
def posCount(list):
    pCount = 0
    for x in range(0, len(list), 1):
        if(list[x] > 0):
            print(pCount)
        #end of if statement
    #end of for loop
    list[len(list)-1] = pCount
    return list
#end of def
print(posCount([-1,1,1,1]))
endQuestion()

# 3. Sum Total - Create a function that takes a list and returns the sum of all the values in the list.
#     Example: sum_total([1,2,3,4]) should return 10
#     Example: sum_total([6,3,-2]) should return 7
def totalSum(list):
    sum = 0
    for x in range(len(list)):
        sum += list[x]
    #end of for loop
    return sum
#end of def
print("Sum of list is:", totalSum([1,2,3,4]))
endQuestion()

# 4. Average - Create a function that takes a list and returns the average of all the values.x
#     Example: average([1,2,3,4]) should return 2.5
def avg(list):
    sum = 0
    for x in range(len(list)):
        sum += list[x]
    #end of for loop
    return (sum / len(list))
#end of def
print("Average is:", avg([1,2,3,4]))
endQuestion()

# 5. Length - Create a function that takes a list and returns the length of the list.
#     Example: length([37,2,1,-9]) should return 4
#     Example: length([]) should return 0
def length(list):
    return len(list)
#end of def
print("Length is:", length([1,2,3,4]))
endQuestion()

# 6. Minimum - Create a function that takes a list of numbers and returns the minimum value in the list. If the list is empty, have the function return False.
#     Example: minimum([37,2,1,-9]) should return -9
#     Example: minimum([]) should return False
def minimum(list):
    min = list[0]
    if(len(list) > 0):
        for x in range(len(list)):
            if(min > list[x]):
                min = list[x]
            #end of if statement
        #end of for loop
    #end of if statement
    else:
        return "False"
    #end of else statement
    return min
#end of def
print("Lowest number is:", minimum([37,2,1,-9]))
endQuestion()

# 7. Maximum - Create a function that takes a list and returns the maximum value in the list. If the list is empty, have the function return False.
#     Example: maximum([37,2,1,-9]) should return 37
#     Example: maximum([]) should return False
def maximum(list):
    max = list[0]
    if(len(list) > 0):
        for x in range(len(list)):
            if(max < list[x]):
                max = list[x]
            #end of if statement
        #end of for loop
    #end of if statement
    else:
        return "False"
    #end of else statement
    return max
#end of def
print("Highest number is:", maximum([37,2,1,-9]))
endQuestion()

# 8. Ultimate Analysis - Create a function that takes a list and returns a dictionary that has the sumTotal, average, minimum, maximum and length of the list.
#     Example: ultimate_analysis([37,2,1,-9]) should return {'sumTotal': 31, 'average': 7.75, 'minimum': -9, 'maximum': 37, 'length': 4 }
def analysis(list):
    sum = 0
    avg = 0
    min = list[0]
    max = list[0]
    for x in range(len(list)):
        sum += list[x] #sum total
        avg = sum / len(list) #average
        if(min > list[x]):
            min = list[x]
        #end of if statement
        if(max < list[x]):
            max = list[x]
        #end of if statement
    #end of for loop
    ana_dict = {"Sum Total":sum, "Average":avg, "Minimum":min, "Maximum":max, "Length":len(list)}
    return ana_dict
#end of def
print(analysis([37,2,1,-9]))
endQuestion()

# 9. Reverse List - Create a function that takes a list and return that list with values reversed. Do this without creating a second list. (This challenge is known to appear during basic technical interviews.)
#     Example: reverse_list([37,2,1,-9]) should return [-9,1,2,37]
def reverse(list):
    last = list[len(list)-1]
    print(last)
    for x in range(len(list)-1, -1, -1):
        list[x] = list[x-1]
    #end of for loop
    list[0] = last
    return list
#end of def
print(reverse([37,2,1,-9]))
endQuestion()