var testArr = [6,3,5,1,2,4]

//Challenge 1: Print Values and Sum
//Expected output:
// Num 6, Sum 6
// Num 3, Sum 9
// Num 5, Sum 14
// Num 1, Sum 15
// Num 2, Sum 17
// Num 4, Sum 21
var sum = 0;
for(var x=0; x<testArr.length; x++){
    var num = testArr[x];
    sum += num;
    console.log("Num ", num + ", Sum", sum);
}
console.log("End of challenge 1");

// Challenge 2: Value * Position
// Expected output:
// [0,3,10,3,8,20]
for(var y=0; y<testArr.length; y++){
    testArr[y] *= y;
}
console.log(testArr);
console.log("End of challenge 2");