var q = 0;
function endOfQuestion(){
    q++;
    console.log("====End of question "+q+"====");
}

// 1. Biggie Size - Given an array, write a function that changes all positive numbers in the array to the string "big".  Example: makeItBig([-1,3,5,-5]) returns that same array, changed to [-1, "big", "big", -5].
function posBig(arr){
    for(var i=0; i<arr.length; i++){
        if(arr[i] > 0){
            arr[i] = "big";
        }
    }
    console.log(arr);
}
posBig([1,-5,-8,7]);
endOfQuestion();

// 2. Print Low, Return High - Create a function that takes in an array of numbers.  The function should print the lowest value in the array, and return the highest value in the array.
function printLowReturnHigh(arr){
    var low = arr[0];
    var high = arr[0];
    for(var i=0; i<arr.length; i++){
        if(low > arr[i]){
            low = arr[i];
        }
        if(high < arr[i]){
            high = arr[i];
        }
    }
    console.log("Low is", low);
    return high;
}
printLowReturnHigh([1,8,2,6,4]);
endOfQuestion();

// 3. Print One, Return Another - Build a function that takes in an array of numbers.  The function should print the second-to-last value in the array, and return the first odd value in the array.
function printOneReturnAnother(arr){
    var odd = 0;
    var secondLast = arr[arr.length-2];
    for(var i=0; i<arr.length; i++){
        if(arr[i] % 2 == 1){
            odd = arr[i];
            break;
        }
    }
    console.log("Second to last value is", secondLast);
    return odd;
}
printOneReturnAnother([2,1,6,7,8,9]);
endOfQuestion();

// 4. Double Vision - Given an array (similar to saying 'takes in an array'), create a function that returns a new array where each value in the original array has been doubled.  Calling double([1,2,3]) should return [2,4,6] without changing the original array.
function double(arr){
    for(var i=0; i<arr.length; i++){
        arr[i] = arr[i] * 2;
    }
    return arr;
}
console.log("Array doubled:", double([1,3,2,8,5]));
endOfQuestion();

// 5. Count Positives - Given an array of numbers, create a function to replace the last value with the number of positive values found in the array.  Example, countPositives([-1,1,1,1]) changes the original array to [-1,1,1,3] and returns it.
function posCount(arr){
    var count = 0;
    for(var i=0; i<arr.length; i++){
        if(arr[i]>0){
            count++;
        }
    }
    arr[arr.length-1] = count;
    return arr;
}
console.log(posCount([-5,1,-3,5,6,-4,7]));
endOfQuestion();

// 6. Evens and Odds - Create a function that accepts an array.  Every time that array has three odd values in a row, print "That's odd!".  Every time the array has three evens in a row, print "Even more so!".
function evensAndOdds(arr){
    var evenCount = 0;
    var oddCount = 0;
    for(var i=0; i<arr.length; i++){
        if(arr[i] % 2 == 0){
            evenCount++;
        }
        if(evenCount > 0 && arr[i] % 2 == 1){
            evenCount = 0;
        }
        if(arr[i] % 2 == 1){
            oddCount++;
        }
        if(oddCount > 0 && arr[i] % 2 == 0){
            oddCount = 0;
        }
        if(evenCount == 3){
            console.log("Even more so!");
        }
        if(oddCount == 3){
            console.log("That's odd!");
        }
    }
}
evensAndOdds([2,4,3,1,5,9,7,4,6,8]);
endOfQuestion();

// 7. Increment the Seconds - Given an array of numbers arr, add 1 to every other element, specifically those whose index is odd (arr[1], arr[3], arr[5], etc).  Afterward, console.log each array value and return arr.
function incSeconds(arr){
    for(var i=0; i<arr.length; i++){
        if(i % 2 == 1){
            arr[i]++;
        }
    }
    console.log(arr);
    return arr;
}
incSeconds([1,2,3,4,5,6]);
endOfQuestion();

// 8. Previous Lengths - You are passed an array (similar to saying 'takes in an array' or 'given an array') containing strings.  Working within that same array, replace each string with a number - the length of the string at the previous array index - and return the array.  For example, previousLengths(["hello", "dojo", "awesome"]) should return ["hello", 5, 4]. Hint: Can for loops only go forward?
function prevLength(arr){
    var prevString = "";
    for(var i=arr.length-1; i>0; i--){
        prevString = arr[i-1];
        arr[i] = prevString.length;
    }
    console.log(arr);
    return arr;
}
prevLength(["duck","dojo","awesome","super"]);
endOfQuestion();

// 9. Add Seven - Build a function that accepts an array. Return a new array with all the values of the original, but add 7 to each. Do not alter the original array.  Example, addSeven([1,2,3]) should return [8,9,10] in a new array.
function addSeven(arr){
    var newArr = [];
    for(var i=0; i<arr.length; i++){
        newArr.push(arr[i]+7);
    }
    return newArr;
}
console.log(addSeven([1,2,3]));
endOfQuestion();

// 10. Reverse Array - Given an array, write a function that reverses its values, in-place.  Example: reverse([3,1,6,4,2]) returns the same array, but now contains values reversed like so... [2,4,6,1,3].  Do this without creating an empty temporary array.  (Hint: you'll need to swap values).
function reverse(arr){
    for(var i=0; i<=(arr.length-1)/2; i++){
        temp = arr[i];
        arr[i] = arr[arr.length-1-i];
        arr[arr.length-1-i] = temp;
    }
    return arr;
}
console.log(reverse([1,2,3,4,5,6,7]));
endOfQuestion();

// 11. Outlook: Negative - Given an array, create and return a new one containing all the values of the original array, but make them all negative (not simply multiplied by -1). Given [1,-3,5], return [-1,-3,-5].
function outNeg(arr){
    var newArr = [];
    for(var i=0; i<arr.length; i++){
        if(arr[i] > 0){
            temp = arr[i] - (arr[i]*2);
            newArr.push(temp);
        }
        else{
            newArr.push(arr[i]);
        }
    }
    return newArr;
}
console.log(outNeg([1,-3,5]));
endOfQuestion();

// 12. Always Hungry - Create a function that accepts an array, and prints "yummy" each time one of the values is equal to "food".  If no array values are "food", then print "I'm hungry" once.
function hungry(arr){
    var food = ["fruit","meat","fish","vegetable","bread","soup"]
    var foodCount = 0;
    for(var i=0; i<arr.length; i++){
        for(var x=0; x<arr.length; x++){
            if(arr[i] == food[x]){
                console.log("yummy")
                foodCount++;
            }
        }
    }
    if(foodCount == 0){
        console.log("I'm hungry");
    }
}
hungry(["meat","dog","fruit","helmet"])
hungry(["metal","instrument","computer","helmet"])
endOfQuestion();

// 13. Swap Toward the Center - Given an array, swap the first and last values, third and third-to-last values, etc.  Example: swapTowardCenter([true,42,"Ada",2,"pizza"]) turns the array into ["pizza", 42, "Ada", 2, true].  swapTowardCenter([1,2,3,4,5,6]) turns the array into [6,2,4,3,5,1].  No need to return the array this time.
function swapCenter(arr){
    for(var i=0; i<=(arr.length-1)/2; i++){
        if(i % 2 == 0){
            temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
    }
    console.log(arr);
}
swapCenter([true,42,"ada",2,"pizza"]);
swapCenter([1,2,3,4,5,6]);
endOfQuestion();

// 14. Scale the Array - Given an array arr and a number num, multiply all values in the array arr by the number num, and return the changed array arr.  For example, scaleArray([1,2,3], 3) should return [3,6,9].
function scale(arr,num){
    for(var i=0; i<arr.length; i++){
        arr[i] *= num;
    }
    return arr;
}
console.log(scale([1,2,3,4,5,6], 5));
endOfQuestion();