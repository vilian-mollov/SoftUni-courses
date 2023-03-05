let startChar = "#";
let endChar = ":";

function getRangeOfChars(startChar, endChar) {
  let start = Math.min(startChar.charCodeAt(0), endChar.charCodeAt(0));
  let end = Math.max(startChar.charCodeAt(0), endChar.charCodeAt(0));
  let range = [];

  for (let i = start; i <= end; i++) {
    range.push(String.fromCharCode(i));
  }

  return range.join(" ");
}

console.log(getRangeOfChars(startChar, endChar));
