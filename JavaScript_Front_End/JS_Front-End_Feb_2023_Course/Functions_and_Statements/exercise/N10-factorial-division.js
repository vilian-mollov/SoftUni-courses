let firstN = 6;
let secondN = 2;

function factorialDivision(firstN, secondN) {

    return (factorial(firstN) / factorial(secondN)).toFixed(2);

    function factorial(number) {
        if (number === 1) {
            return number;
        }
        return number * factorial(number - 1);
    }

}

console.log(factorialDivision(firstN, secondN));
