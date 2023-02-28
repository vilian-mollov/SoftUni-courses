// '+', '-', '*', '/', '%', '**'.

function operation (numb1, numb2, operator) {
    switch (operator) {
        case "+":
            return numb1 + numb2;
        case "-":
            return numb1 - numb2;
        case "*":
            return numb1 * numb2;
        case "/":
            return numb1 / numb2;
        case "%":
            return numb1 % numb2;
        case "**":
            return numb1 ** numb2;
    }
}


console.log(operation(2, 5, '**'));
