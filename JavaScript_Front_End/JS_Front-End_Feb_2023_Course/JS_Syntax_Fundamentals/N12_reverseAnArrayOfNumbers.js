let array = [14, 32, 21, 23, 221, 771];
let n = 55;

function reverseN_NumbersOfArray(n, array) {
  let tempArr = [];

  if (n > array.length - 1) {
    n = array.length -1;
  }

  for (let index = 0; index < n; index++) {
    tempArr.push(array[index]);
  }

  tempArr.reverse();

  let output = ""
  for (let index = 0; index < tempArr.length; index++) {
    output += tempArr[index] + " ";
  }

  output.trim();

  return output;
}

console.log(reverseN_NumbersOfArray(n, array));
