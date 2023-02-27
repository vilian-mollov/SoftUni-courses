

function findLargestNumb (n1, n2, n3) {
    let largest = 0;

    if (n1 >= n2 && n1 >= n3) {
        largest = n1;
    } else if (n2 >= n1 && n2 >= n3) {
        largest = n2;
    } else if (n3 >= n1 && n3 >= n2) {
        largest = n3;
    }

    return `The largest number is ${largest}.`;
}

console.log(findLargestNumb(5,48,8));