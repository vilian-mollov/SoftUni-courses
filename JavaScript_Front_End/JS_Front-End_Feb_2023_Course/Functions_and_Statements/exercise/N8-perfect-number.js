let number = 6;

function checkIfItsPerfect(number) {
    let devisors = [];
    for (let i = 1; i < number / 2 + 1; i++) {
        if (number % i === 0) {
            devisors.push(i);
        }
    }

    let sum = devisors.reduce((f,s) => f + s,0)

    return sum === number ? "We have a perfect number!" : "It's not so perfect.";
}


console.log(checkIfItsPerfect(number));