# 1. TASK: print "Hello World"
print("Hello World")

# 2. print "Hello Noelle!" with the name in a variable
name = "Noelle"
print("Hello", name)	# with a comma
print("Hello " + name)	# with a +
# 2a. Store your name in a variable, and then use it to print the string “Hello {{your name}}!” using a comma in the print function
first_name = "Charles"
print("Hello", first_name)
# 2b. Store your name in a variable, and then use it to print the string “Hello {{your name}}!” using a + in the print function
print("hello "+ first_name)

# 3. print "Hello 42!" with the number in a variable
name = "42"
print("Hello", name, "!")	# with a comma
print("Hello " + name + "!")	# with a +	-- this one should give us an error!
# NINJA BONUS: Figure out how to resolve the error from above, without changing the + sign to a comma
# 3a. Store your favorite number in a variable, and then use it to print the string “Hello {{num}}!” using a comma in the print function
fav_num = "9"
print("Hello", fav_num)
#3b. Store your favorite number in a variable, and then use it to print the string “Hello {{num}}!” using a + in the print function
print("Hello " + fav_num)

# 4. print "I love to eat sushi and pizza." with the foods in variables
fave_food1 = "sushi"
fave_food2 = "pizza"
print("I love to eat {} and {}.".format(fave_food1, fave_food2)) # with .format()
print(f"I love to eat {fave_food1} and {fave_food2}.") # with an f string
# 4a. Store 2 of your favorite foods in variables, and then use them to print the string “I love to eat {{food_one}} and {{food_two}}.” with the format method
user_food1 = "sushi"
user_food2 = "curry"
user_food3 = "pizza"
print("I love to eat {} and {}.".format(user_food1, user_food2))
# 4b. Store 2 of your favorite foods in variables, and then use them to print the string “I love to eat {{food_one}} and {{food_two}}.” with f-strings
print(f"I love to eat {user_food1} and {user_food2}.")
# NINJA BONUS: Spend a few minutes playing around with other string methods to see what’s out there!
print("I love to eat %s and %s." % (user_food1, user_food2))
print(user_food2.title())
print(user_food2.split("r"))
print(user_food2.join(("pizza","blah","halp")))