function addAndSubtract(n1, n2, n3) {
  return subtract(add(n1, n2), n3);

  function add(n1, n2) {
    return n1 + n2;
  }

  function subtract(n1, n2) {
    return n1 - n2;
  }
}

console.log(addAndSubtract(5,10, 11));
