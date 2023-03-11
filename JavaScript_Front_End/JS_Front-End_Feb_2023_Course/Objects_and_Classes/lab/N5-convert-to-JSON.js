function convertToJSON(name, lastName, hairColor) {
    let obj = {name, lastName, hairColor}

    return JSON.stringify(obj);
}

console.log(convertToJSON("Alucard", "Dracula", "black"));