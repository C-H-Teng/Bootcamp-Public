import unittest

q = 0
def endQuestion():
    global q
    q += 1
    print("End of question", q)
#end of def

#1. reverseList - Write a function that reverses the values in the list (without creating a temporary array).
#    Example: reverseList([1,3,5]) should return [5,3,1]
#    Example Test: assertEqual( reverseList([1,3,5]), [5,3,1] )
#    Add at least 3 other test cases
def reverseList(arr):
    for x in range(round(len(arr)/2)):
        arr[x], arr[len(arr)-1-x] = arr[len(arr)-1-x], arr[x]
    #end of for loop
    return arr
#end of def
print(reverseList([1,3,5]))
print(reverseList([1,2,3,4,5,6]))
print(reverseList([3,5,7,9,11,13,15]))

endQuestion()

#2. isPalindrome - Write a function that checks whether the given word is a palindrome (a word that spells the same backward).
#    Example: isPalindrome("racecar") should return True
#    Example Test: assertEqual( isPalindrome("racecar"), True ) or assertTrue( isPalindrome("racecar"))
#    Example Test: assertFalse( isPalindrome("rabcr") ).
#    Add at least 5 other test cases

def palindrome(str):
    for x in range(round(len(str)/2)):
        if(str[x] == str[len(str)-1-x]):
            return True
        else:
            return False
    #end of for loop
#end of def
print(palindrome("racecar"))
print(palindrome("bbo"))
print(palindrome("bob"))
print(palindrome("kayak"))
print(palindrome("revel"))

endQuestion()

#3. coins - Write a function that determines how many quarters, dimes, nickels, and pennies to give to a customer for a change where you minimize the number of coins you give out.
#    Example: given 87 cents, result should be 3 quarters, 1 dime, 0 nickel and 2 pennies
#    Example Test: assertEqual( coin(87), [3,1,0,2] )
#    Add at least 5 other test cases

def coins(cents):
    coinStack = {
        "quarters" : 0,
        "dimes" : 0,
        "nickels" : 0,
        "pennies" : 0
    }
    coinStack["quarters"] = int(cents / 25)
    cents -= (coinStack["quarters"] * 25)
    coinStack["dimes"] = int(cents / 10)
    cents -= (coinStack["dimes"] * 10)
    coinStack["nickels"] = int(cents / 5)
    cents -= (coinStack["nickels"] * 5)
    coinStack["pennies"] = cents
    return coinStack
#end of def
print(coins(87))
print(coins(136))
print(coins(62))
print(coins(18))
print(coins(544))

endQuestion()

#4. BONUS - factorial - Write a recursive function that returns the factorial of a given number. Remember that the factorial of a number is the product of all the numbers between 1 and the given number (eg. 4! = 4*3*2*1).
#    Example: factorial(5) should return 120.
#    Add at least 3 test cases
def factorial(num):
    total = num
    while(num > 1):
        num -= 1
        total *= num
    return total
#end of def
print(factorial(5))
print(factorial(10))
print(factorial(25))

endQuestion()

#5. BONUS - fibonacci - Write a recursive function that accepts a number, n, and returns the nth Fibonacci number from the sequence. The first two Fibonacci numbers are 0 and 1. Every number after that is calculated by adding the previous 2 numbers from the sequence. (i.e. 0, 1, 1, 2, 3, 5, 8, 13, 21 ...)
#    The sequence starts with fib(0) so fib(5) is actually 5 and fib(4) is 3. https://en.wikipedia.org/wiki/Fibonacci_number
#    Add at least 3 test cases

def fibonacci(n):
    fibArr = [0,1]
    for x in range(2, n+1, 1):
        fibArr.append(fibArr[x-1] + fibArr[x-2])
    return fibArr[x]
#end of def
print(fibonacci(5))
print(fibonacci(10))
print(fibonacci(15))

endQuestion()


class test(unittest.TestCase):
    def test_reverse1(self):
        self.assertEqual(reverseList([1,3,5]), [5,3,1])
    def test_reverse2(self):
        self.assertEqual(reverseList([1,2,3,4,5,6]), [6, 5, 4, 3, 2, 1])
    def test_reverse3(self):
        self.assertEqual(reverseList([3,5,7,9,11,13,15]), [15, 13, 11, 9, 7, 5, 3])
    def test_palin1(self):
        self.assertEqual(palindrome("racecar"), True)
    def test_palin2(self):
        self.assertEqual(palindrome("bbo"), False)
    def test_palin3(self):
        self.assertTrue(palindrome("bob"))
    def test_palin4(self):
        self.assertTrue(palindrome("kayak"))
    def test_palin5(self):
        self.assertFalse(palindrome("revel"))
    def test_coins1(self):
        self.assertEqual(coins(87), {'quarters': 3, 'dimes': 1, 'nickels': 0, 'pennies': 2})
    def test_coins2(self):
        self.assertEqual(coins(136), {'quarters': 5, 'dimes': 1, 'nickels': 0, 'pennies': 1})
    def test_coins3(self):
        self.assertEqual(coins(62), {'quarters': 2, 'dimes': 1, 'nickels': 0, 'pennies': 2})
    def test_coins4(self):
        self.assertEqual(coins(18), {'quarters': 0, 'dimes': 1, 'nickels': 1, 'pennies': 3})
    def test_coins5(self):
        self.assertEqual(coins(544), {'quarters': 21, 'dimes': 1, 'nickels': 1, 'pennies': 4})
    def test_factorial1(self):
        self.assertEqual(factorial(5), (1*2*3*4*5))
    def test_factorial2(self):
        self.assertEqual(factorial(10), (1*2*3*4*5*6*7*8*9*10))
    def test_factorial3(self):
        self.assertEqual(factorial(25), (1*2*3*4*5*6*7*8*9*10*11*12*13*14*15*16*17*18*19*20*21*22*23*24*25))
    def test_fibonacci1(self):
        self.assertEqual(fibonacci(5), 3+2)
    def test_fibonacci2(self):
        self.assertEqual(fibonacci(10), 34+21)
    def test_fibonacci3(self):
        self.assertEqual(fibonacci(15), 377+233)
unittest.main()