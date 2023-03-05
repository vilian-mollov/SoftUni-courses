let num1 = -6;
let num2 = -12;
let num3 = 14;

let checkSign = (...numbers) => 
numbers.filter(e => e < 0).length % 2 === 0? "Positive": "Negative";

console.log(checkSign(num1, num2, num3));
