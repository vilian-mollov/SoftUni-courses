let n = 7;

function printMatrix(n) {
    return new Array(n).fill(new Array(n).fill(n).join(" ")).join("\n");
}

console.log(printMatrix(n));