var counter = 0;

function colorize() {
  const rows = Array.from(document.querySelectorAll("tr:nth-child(even)"));

  if (counter % 2 === 0) {
    rows.forEach((e) => {
      // e.setAttribute(color, 'red');
      e.style = "background-color:Teal";
    });
  } else {
    rows.forEach((e) => {
      // e.setAttribute(color, 'red');
      e.style = "background-color:white";
    });
  }

  counter++;
}

//Description:
//Write a JS function that changes the color of all even
// rows when the user clicks a button.
// Apply the color "Teal" to the target rows.
