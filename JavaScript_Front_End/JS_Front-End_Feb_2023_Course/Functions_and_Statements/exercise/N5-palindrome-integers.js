let numbers = [123,323,421,121];

function checkForPalindromes(numbers) {
    for (let i = 0; i < numbers.length; i++) {
        let n = numbers[i].toString().split("");
        n = n.reverse();
        let number = "";
        n.forEach(element => {
            number += element;
        });


        if (number === numbers[i].toString()) {
            console.log(true);
        } else {
            console.log(false);
        }
    }
}

checkForPalindromes(numbers);