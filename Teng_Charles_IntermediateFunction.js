var q = 0;
function endOfQuestion(){
    q++;
    console.log("====End of question "+q+"====");
}

// 1. Sigma - Implement function sigma(num) that, given a number, returns the sum of all positive integers up to the given number (inclusive).  Ex: sigma(3) = 6 (or 1+2+3); sigma(5) = 15 (or 1+2+3+4+5).
function sigma(num){
    var total = 0;
    for(var i=1; i<=num; i++){
        total += i;
        console.log(i);
    }
    return total;
}
console.log(sigma(6));
endOfQuestion()

// 2. Factorial - Write a function factorial(num) that, given a number, returns the product (multiplication) of all positive integers from 1 up to the given number (inclusive).  For example, factorial(3) = 6 (or 1*2*3); factorial(5) = 120 (or 1*2*3*4*5).
function factorial(num){
    var total = 1;
    for(var i=1; i<=num; i++){
        total *= i;
        console.log(i);
    }
    return total;
}
console.log(factorial(5));
endOfQuestion()

// 3. Fibonacci - Create a function to generate Fibonacci numbers.  In this famous mathematical sequence, each number is the sum of the previous two, starting with values 0 and 1.  Your function should accept one argument, an index into the sequence (where 0 corresponds to the initial value, 4 corresponds to the value four later, etc).  Examples: fibonacci(0) = 0 (given), fibonacci(1) = 1 (given), fibonacci(2) = 1 (fib(0)+fib(1), or 0+1), fibonacci(3) = 2 (fib(1) + fib(2)3, or 1+1), fibonacci(4) = 3 (1+2), fibonacci(5) = 5 (2+3), fibonacci(6) = 8 (3+5), fibonacci(7) = 13 (5+8).  Do this without using recursion first.  If you don't know what a recursion is yet, don't worry as we'll be introducing this concept in Part 2 of this assignment.
function fib(num){
    var fibArr = [0,1];
    var result = [];
    for(var i=2; i<=num; i++){
        fibArr[i] = fibArr[i-1] + fibArr[i-2];
        result.push(fibArr[i]);
    }
    return result;
}
console.log(fib(7));
endOfQuestion()

// 4. Array: Second-to-Last: Return the second-to-last element of an array. Given [42, true, 4, "Liam", 7], return "Liam".  If array is too short, return null.
function secLast(arr){
    if(arr.length < 2){
        return "null";
    }
    return arr[arr.length-2];
}
console.log(secLast([1]));
console.log(secLast([1,2,3,4,5]));
endOfQuestion()

// 5. Array: Nth-to-Last: Return the element that is N-from-array's-end.  Given ([5,2,3,6,4,9,7],3), return 4.  If the array is too short, return null.
function nthLast(arr,n){
    if(arr.length < n){
        return "null";
    }
    return arr[arr.length-n];
}
console.log(nthLast([1,2],3));
console.log(nthLast([1,2,3,4,5],4));
endOfQuestion()

// 6. Array: Second-Largest: Return the second-largest element of an array. Given [42,1,4,3.14,7], return 7.  If the array is too short, return null.
function secLargest(arr){
    var secMax = 0;
    if(arr.length < 2){
        return "null";
    }
    arr.sort(function(a, b){return a-b});
    secMax = arr[arr.length-2];
    return secMax;
}
console.log("Second largest:", secLargest([42,1,4,3,7]));
endOfQuestion()

// 7. Double Trouble: Create a function that changes a given array to list each existing element twice, retaining original order.  Convert [4, "Ulysses", 42, false] to [4,4, "Ulysses", "Ulysses", 42, 42, false, false].
function dblTrbl(arr){
    var arrClone = arr.slice();
    arr.splice(0)
    for(var i=0; i<arrClone.length; i++){
        arr.push(arrClone[i]);
        arr.push(arrClone[i]);
    }
    return(arr);
}
console.log(dblTrbl([4, "Ulysses", 42, false]));
endOfQuestion()