function getRandomInt(max) {
    return Math.floor(Math.random() * max);
  }

  let numbers = [];

  for (let index = 0; index < 10; index++) {
    numbers.push(getRandomInt(100));
  }


function quickSort(numbers, lowIndex, highIndex) {

    if (lowIndex >= highIndex) {
        return;
    }

    let pivot = numbers[highIndex];

    let lp = lowIndex;
    let rp = highIndex;

    while (lp < rp) {

        while (numbers[lp] <= pivot && lp < rp) {
            lp++;
        }
        while (numbers[rp] >= pivot && lp < rp) {
            rp--;
        }

        let temp = numbers[lp];
        numbers[lp] = numbers[rp];
        numbers[rp] = temp;
    }

    let tempPivot = numbers[highIndex];
            numbers[highIndex] = numbers[rp];
            numbers[rp] = tempPivot;

    quickSort(numbers, lowIndex, lp - 1);
    quickSort(numbers, lp + 1, highIndex);

}

console.log("Before:");
console.log(numbers);


console.log("After:")
quickSort(numbers, 0, numbers.length - 1);
console.log(numbers);
