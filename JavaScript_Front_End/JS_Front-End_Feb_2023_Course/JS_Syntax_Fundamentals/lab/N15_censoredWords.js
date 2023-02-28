let text = 'A small sentence with some small words';
let word = 'small';


function censoring(text, word) {
    // return text.replaceAll(word, "*".repeat(word.length));

    while(text.includes(word)){
        text = text.replace(word, "*".repeat(word.length));
    }
    return text;
}

console.log(censoring(text, word));