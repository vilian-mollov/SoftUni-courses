let word = 'javascript';
let text = 'JavaScript is the best programming language';

function findWord(word, text) {
    let w = word.toLowerCase();
    text = text.toLowerCase();
    return text.includes(w) ? word : `${word} not found!`;
}

console.log(findWord(word,text));
console.log(findWord('python', 'JavaScript is the best programming language'));