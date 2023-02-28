let input = 5;


function calculateRadiusOfCircle (input) {

    if (typeof input === "number") {
       return ((input ** 2) * Math.PI).toFixed(2);
    }else {
        return `We can not calculate the circle area, because we receive a ${typeof input}.`;
    }
}


console.log(calculateRadiusOfCircle(input));