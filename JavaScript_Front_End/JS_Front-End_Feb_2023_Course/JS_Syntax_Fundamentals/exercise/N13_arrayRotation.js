let arr = [52, 43, 13 ,23, 221, 57];
let rotations = 2;

function rotateArray(arr, rotations) {
    for (let index = 0; index < rotations; index++) {
        let temp = arr.shift();
        arr.push(temp);
    }
    return arr.join(" ");
}

console.log(rotateArray(arr, rotations));