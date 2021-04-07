def insertSort(nums):
    for x in range(1, len(nums)):
        strtIdx = nums[x]
        y = x-1
        while y >= 0 and strtIdx < nums[y]:
            nums[y+1] = nums[y]
            y -= 1
        #end of nested while loop
        nums[y + 1] = strtIdx
    #end of for loop
    return nums
#end of def

print(insertSort([5,3,4,2,9,1,6,8,7]))