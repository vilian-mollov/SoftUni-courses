let text = "This is a word and it also is a sentence";
let word = "is";

function countOccurrences(text, word) {
  let count = 0;
  let arr = text.split(/\s+/);

  for (let i = 0; i < arr.length; i++) {

    if (arr[i] === word) {
        count ++;
    }
  }

  return count;
}

console.log(countOccurrences(text, word));
