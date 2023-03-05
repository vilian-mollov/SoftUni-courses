let validPassword = "MyPass123";
let invalidPassword = "Pa$s$s";

function validatePass(password) {
    let isValidLength = (password.length > 10 || password.length < 6)
     ? false : true;

     let reg = /^\w+$/g;
     let digReg = /\d/g;

    let contOnlyLettersNumbs = reg.test(password);
    let haveAtLeastTwoDig = ([...password.matchAll(digReg)].length) >= 2 ? true : false;

    if(!isValidLength){console.log("Password must be between 6 and 10 characters")}
    if(!contOnlyLettersNumbs){console.log("Password must consist only of letters and digits")}
    if(!haveAtLeastTwoDig){console.log("Password must have at least 2 digits")}
    if(isValidLength && contOnlyLettersNumbs && haveAtLeastTwoDig) {
        console.log("Password is valid");
    }

}

console.log("Try valid password:");
validatePass(validPassword);

console.log("\n");

console.log("Try invalid password:");
validatePass(invalidPassword);


