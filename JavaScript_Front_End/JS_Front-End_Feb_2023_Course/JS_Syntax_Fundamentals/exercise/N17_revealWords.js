let  words = 'great, learning';
let text = 'softuni is ***** place for ******** new programming languages';


function replacingStars(words, text) {
 let arr = words.split(", "); 
 for (let i = 0; i < arr.length; i++) {
    text = text.replace('*'.repeat(arr[i].length), arr[i]);
 }

 console.log(text);
}


replacingStars(words,text);