let arr = ["5", "20", "31", "4", "20"];
let step = 2;

function printingWithStep(arr, step) {
  let tempArr = [];

  for (let i = 0; i < arr.length; i += step) {
    
    tempArr.push(arr[i]);
  }
  return tempArr;
}

console.log(printingWithStep(arr, step));
