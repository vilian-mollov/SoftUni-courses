let operandOne = 40;
let operandTwo = 8;
let operator = 'divide';

function operation(operandOne, operandTwo, operator) {
    const add = (f,s) => f + s;
    const multiply = (f,s) => f * s;
    const subtract = (f,s) => f - s;
    const divide = (f,s) => f / s;

    const operationMap = {
        add: add,
        multiply: multiply,
        subtract: subtract,
        divide: divide,
    }

    return operationMap[operator](operandOne,operandTwo);
}

console.log("First example:");
console.log(operation(operandOne,operandTwo,operator));


console.log("Second example:");
console.log(operation(5,5,"multiply"));

