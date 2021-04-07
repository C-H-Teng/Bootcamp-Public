class Underscore:
    def map(self, iterable, callback):
        # your code here
        for i in range(len(iterable)):
            iterable[i] *= 2
        return iterable
    def find(self, iterable, callback):
        # your code here
        x = iterable[0]
        for i in range(len(iterable)):
            if(iterable[i] > 4):
                x = iterable[i]
                return x
    def filter(self, iterable, callback):
        # your code
        newArr = []
        for i in range(len(iterable)):
            if(iterable[i] % 2 == 0):
                newArr.append(iterable[i])
        return newArr
    def reject(self, iterable, callback):
        # your code
        newArr = []
        for i in range(len(iterable)):
            if(iterable[i] % 2 == 1):
                newArr.append(iterable[i])
        return newArr
# you just created a library with 4 methods!
# let's create an instance of our class
_ = Underscore() # yes we are setting our instance to a variable that is an underscore
evens = _.filter([1, 2, 3, 4, 5, 6], lambda x: x % 2 == 0)
# should return [2, 4, 6] after you finish implementing the code above

print(_.map([1,2,3], lambda x: x*2)) # should return [2,4,6]
print(_.find([1,2,3,4,5,6], lambda x: x>4)) # should return the first value that is greater than 4
print(_.filter([1,2,3,4,5,6], lambda x: x%2==0)) # should return [2,4,6]
print(_.reject([1,2,3,4,5,6], lambda x: x%2==0)) # should return [1,3,5]