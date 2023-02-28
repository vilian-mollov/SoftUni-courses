let arr = ["John", "Bob", "Christina", "Ema"];

function sortNames(arr) {
  arr.sort((f,s) => {
      return f.localeCompare(s);
  });

  for (let index = 0; index < arr.length; index++) {
    console.log(index + 1 + "." + arr[index]);
  }
}


sortNames(arr);

