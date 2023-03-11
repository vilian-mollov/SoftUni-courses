function phoneBookParser(phoneBook) {
  let assocArr = {};
  phoneBook.forEach((set) => {
    let tokens = set.split(" ");
    assocArr[tokens[0]] = tokens[1];
  });

  for (const key in assocArr) {
        console.log(`${key} -> ${assocArr[key]}`);
  }
//   return assocArr;
}


  phoneBookParser([
    "Tim 0834212554",
    "Peter 0877547887",
    "Bill 0896543112",
    "Tim 0876566344",
  ]);

