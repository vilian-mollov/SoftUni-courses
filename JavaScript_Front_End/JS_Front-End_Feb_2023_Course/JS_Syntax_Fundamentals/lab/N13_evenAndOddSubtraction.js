let array = [1, 2, 3, 4, 5, 6];


function subOddFromEven (array) {
    let sumOfOdd = 0;
    let sumOfEven = 0;

    for (let index = 0; index < array.length; index++) {
        if (array[index] % 2 === 0) {
            sumOfEven += array[index];
        }else {
            sumOfOdd += array[index];
        }
    }

    return sumOfEven - sumOfOdd;

}


console.log(subOddFromEven(array));
