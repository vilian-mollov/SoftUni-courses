let number = 40;

function showLoading(number) {
    let bar = [];
    if (number === 100) {
        bar = ['%'.repeat(10)]
        return `100% Complete!\n`
              +`[${bar}]`;
    }

    bar = [...'%'.repeat(number/10)]
    bar.push(...'.'.repeat(10 - Math.floor(number/10)));
    return `${number} Complete!\n`
    +`[${bar.join("")}]`;
}

console.log(showLoading(32));

