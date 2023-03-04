let numbers = [1, 65, 3, 52, 48, 63, 31, -3, 18, 56];


function sortNumbs(numbers) {
   let arr = [...numbers].sort((f,s) => f - s);

   let mergedArr = [];
   let step = 0;

  while (arr.length > 0) {
    
    if (step % 2 === 0) {
        mergedArr[step] = arr.shift();
    } else {
        mergedArr[step] = arr.pop();
    }

    step++;
  }

   return mergedArr;
}

console.log(sortNumbs(numbers).join(" "));


