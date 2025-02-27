q = 0
def endQuestion():
    global q
    q += 1
    print("End of question", q)
# end of def

#1. Update Values in Dictionaries and Lists
x = [ [5,2,3], [10,8,9] ] 
students = [ #list containing dictionaries
    {'first_name':  'Michael', 'last_name' : 'Jordan'},
    {'first_name' : 'John', 'last_name' : 'Rosales'}
]
sports_directory = { #dictionary containing lists
    'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
    'soccer' : ['Messi', 'Ronaldo', 'Rooney']
}
z = [ {'x': 10, 'y': 20} ]
#a. Change the value 10 in x to 15. Once you're done, x should now be [ [5,2,3], [15,8,9] ].
x[1][0] = 10
print(x)
#b. Change the last_name of the first student from 'Jordan' to 'Bryant'
students[0]["last_name"] = "Bryant"
print(students[0])
#c. In the sports_directory, change 'Messi' to 'Andres'
sports_directory["soccer"][0] = "Andres"
print(sports_directory["soccer"])
#d. Change the value 20 in z to 30
z[0]["y"] = 30
print(z)
endQuestion()

#2. Iterate Through a List of Dictionaries
    #Create a function iterateDictionary(some_list) that, given a list of dictionaries, the function loops through each dictionary in the list and prints each key and the associated value.
students = [
    {'first_name' : 'Michael', 'last_name' : 'Jordan'},
    {'first_name' : 'John', 'last_name' : 'Rosales'},
    {'first_name' : 'Mark', 'last_name' : 'Guillen'},
    {'first_name' : 'KB', 'last_name' : 'Tonel'}
]

def iterateDict(some_list, some_key):
    for x in some_list:
        print(x[some_key])
    #end of for loop
#end of def
iterateDict(students, "first_name")
iterateDict(students, "last_name")

# should output: (it's okay if each key-value pair ends up on 2 separate lines;
# bonus to get them to appear exactly as below!)
# first_name - Michael, last_name - Jordan
# first_name - John, last_name - Rosales
# first_name - Mark, last_name - Guillen
# first_name - KB, last_name - Tonel
endQuestion()

#3. Get Values From a List of Dictionaries
    #Create a function iterateDictionary2(key_name, some_list) that, given a list of dictionaries and a key name, the function prints the value stored in that key for each dictionary.
def iterateDict2(key_name, some_list):
    for x in range(len(some_list)):
        print(some_list[x][key_name])
    #end of for loop
#end of def
iterateDict2("first_name", students)
iterateDict2("last_name", students)
endQuestion()

#4. Iterate Through a Dictionary with List Values
    #Create a function printInfo(some_dict) that given a dictionary whose values are all lists, prints the name of each key along with the size of its list, and then prints the associated values within each key's list.
dojo = {
    'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
    'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
}

def printInfo(some_dict):
    for x in some_dict:
        print(len(some_dict[x]), x)
        for y in some_dict[x]:
            print(y)
        #end of nested for loop
    #end of for loop
#end of def
printInfo(dojo)
endQuestion()