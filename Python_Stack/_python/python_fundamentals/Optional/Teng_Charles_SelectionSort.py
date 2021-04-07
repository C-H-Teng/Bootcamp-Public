def selSort(nums):
    for x in range(len(nums)):
        minIdx = x
        for y in range(x + 1, len(nums)):
            if nums[minIdx] > nums[y]:
                minIdx = y
        #end of nested for loop
        nums[x], nums[minIdx] = nums[minIdx], nums[x]
    #end of for loop
    return nums
#end of def

print(selSort([5,3,4,2,9,1,6,8,7]))