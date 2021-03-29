var q = 0;
function endOfQuestion(){
    q++;
    console.log("====End of question "+q+"====");
}

// 1. Get 1 to 255 - Write a function that returns an array with all the numbers from 1 to 255.
function oneTo255(){
    var arrOne = []
    for(var i=1; i<256; i++){
        arrOne.push(i);
    }
    console.log("Array of 1-255:", arrOne);
}
oneTo255();
endOfQuestion();

// 2. Get even 1000 - Write a function that would get the sum of all the even numbers from 1 to 1000.  You may use a modulus operator for this exercise.
function evenSumOf1000(){
    var sum = 0;
    for(var i=0; i<1001; i++){
        if(i % 2 == 0){
            sum += i;
        }
    }
    return sum;
}
console.log("Sum of even numbers up to 1000 is", evenSumOf1000());
endOfQuestion();

// 3. Sum odd 5000 - Write a function that returns the sum of all the odd numbers from 1 to 5000. (e.g. 1+3+5+...+4997+4999).
function oddSumOf5000(){
    var sum = 0;
    for(i=0; i<5001; i++){
        if(i % 2 == 1){
            sum += i;
        }
    }
    console.log("Sum of odd numbers up to 5000 is", sum);
}
oddSumOf5000();
endOfQuestion();

// 4. Iterate an array - Write a function that returns the sum of all the values within an array. (e.g. [1,2,5] returns 8. [-5,2,5,12] returns 14).
function sumOfarr(arr){
    var sum = 0;
    for(var i=0; i<arr.length; i++){
        sum += arr[i];
    }
    return sum;
}
console.log("Sum is: " + sumOfarr([-5,2,5,12]));
endOfQuestion();

// 5. Find max - Given an array with multiple values, write a function that returns the maximum number in the array. (e.g. for [-3,3,5,7] max is 7)
function findMax(x){
    var max = x[0];
    for(var i=1; i<x.length; i++){
        if(max < x[i]){
            max = x[i];
        }
    }
    console.log("Max number in the array is", max);
}
findMax([-3,5,8,6,10,2]);
endOfQuestion();

// 6. Find average - Given an array with multiple values, write a function that returns the average of the values in the array. (e.g. for [1,3,5,7,20] average is 7.2)
var avg = 0;
function arrAvg(x){
    for(var i=0; i<x.length; i++){
        avg += x[i];
    }
    avg = avg / x.length;
    return avg;
}
console.log("Average of array is", arrAvg([1,3,5,7,20]));
endOfQuestion();

// 7. Array odd - Write a function that would return an array of all the odd numbers between 1 to 50. (ex. [1,3,5, .... , 47,49]). Hint: Use 'push' method.
function oddArr(){
    var arrOdd = [];
    for(var i=0; i<50; i++){
        if(i % 2 == 1){
            arrOdd.push(i);
        }
    }
    console.log(arrOdd);
}
oddArr();
endOfQuestion();

// 8. Greater than Y - Given value of Y, write a function that takes an array and returns the number of values that are greater than Y. For example if arr = [1, 3, 5, 7] and Y = 3, your function will return 2. (There are two values in the array greater than 3, which are 5, 7).
function grtrThanY(y, arr){
    var numGrtr = 0;
    for(var i=0; i<arr.length; i++){
        if(arr[i] > y){
            numGrtr++;
        }
    }
    return numGrtr;
}
console.log("Amount of numbers greater than Y:", grtrThanY(6, [1,3,5,7]));
endOfQuestion();

// 9. Squares - Given an array with multiple values, write a function that replaces each value in the array with the value squared by itself. (e.g. [1,5,10,-2] will become [1,25,100,4])
function square(arr){
    for(var i=0; i<arr.length; i++){
        arr[i] *= arr[i];
    }
    console.log(arr);
}
square([1,5,10,-2])
endOfQuestion();

// 10. Negatives - Given an array with multiple values, write a function that replaces any negative numbers within the array with the value of 0. When the program is done the array should contain no negative values. (e.g. [1,5,10,-2] will become [1,5,10,0])
function noNegs(arr){
    for(var i=0; i<arr.length; i++){
        if(arr[i] < 0){
            arr[i] = 0;
        }
    }
    return arr;
}
console.log(noNegs([-1,1,5,-8,4,-5]))
endOfQuestion();

// 11. Max/Min/Avg - Given an array with multiple values, write a function that returns a new array that only contains the maximum, minimum, and average values of the original array. (e.g. [1,5,10,-2] will return [10,-2,3.5])
function maxMinAvg(arr){
    var max = arr[0];
    var min = arr[0];
    var sum = 0;
    var newArr = [];
    for(var i=0; i<arr.length; i++){
        if(max < arr[i]){
            max = arr[i];
        }
        if(min > arr[i]){
            min = arr[i];
        }
        sum += arr[i];
    }
    newArr.push(max);
    newArr.push(min);
    newArr.push(sum/arr.length);
    console.log(newArr);
}
maxMinAvg([1,5,10,-2])
endOfQuestion();

// 12. Swap Values - Write a function that will swap the first and last values of any given array. The default minimum length of the array is 2. (e.g. [1,5,10,-2] will become [-2,5,10,1]).
function swapFirstLast(arr){
    temp = arr[0];
    arr[0] = arr[arr.length-1];
    arr[arr.length-1] = temp;
    return arr;
}
console.log("Array with first and last values swapped:", swapFirstLast([3,5,10,8]));
endOfQuestion();

// 13. Number to String - Write a function that takes an array of numbers and replaces any negative values within the array with the string 'Dojo'. For example if array = [-1,-3,2], your function will return ['Dojo','Dojo',2].
function negDojo(arr){
    for(var i=0; i<arr.length; i++){
        if(arr[i] < 0){
            arr[i] = "Dojo";
        }
    }
    console.log(arr);
}
negDojo([1,-3,5,4,-7,5]);
endOfQuestion();