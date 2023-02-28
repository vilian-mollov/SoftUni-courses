function cooking(numb, ...operations) {
let number = parseInt(numb);
  operations.forEach((element) => {
    switch (element) {
      case "chop":
        number /= 2;
        break;
      case "dice":
        number = Math.sqrt(number);
        break;
      case "spice":
        number++;
        break;
      case "bake":
        number *= 3;
        break;
      case "fillet":
        number -= number * 0.20;
        break;
    }

    console.log(number);
  });
}

console.log("First:")
cooking('32', "chop", "chop", "chop", "chop", "chop");

console.log("Second:")
cooking('9', 'dice', 'spice', 'chop', 'bake', 'fillet');
