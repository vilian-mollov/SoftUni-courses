function convertToObject(JSON_String) {
  let obj = JSON.parse(JSON_String);
  for (const key in obj) {
    console.log(key +": "+ obj[key]);
  }
  return obj;
}

console.log(convertToObject('{"name": "Peter", "age": 35, "town": "Plovdiv"}'));
