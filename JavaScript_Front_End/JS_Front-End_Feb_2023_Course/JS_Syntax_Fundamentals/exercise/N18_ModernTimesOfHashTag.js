let text = 'The symbol # is known #variously in English-speaking #regions as the #number sign';

function printHashTags(text) {
    let arr = text.split(" ");

    for (let i = 0; i < arr.length; i++) {
        if (arr[i].charAt(0) === '#') {
            let wordArr = arr[i].split("");
            let valid = true;
            for (let j = 1; j < wordArr.length; j++) {
                let number = wordArr[j].charCodeAt(0);
               if(number >= 65 && number <= 90 || number >= 97 && number <= 122){
            
               } else {
                valid = false;
               }     
            }

            if (arr[i].length === 1) {
                valid = false;
            }

            if (valid) {
                console.log(arr[i].substring(1));
            }
        }
        
    }

}

printHashTags(text);