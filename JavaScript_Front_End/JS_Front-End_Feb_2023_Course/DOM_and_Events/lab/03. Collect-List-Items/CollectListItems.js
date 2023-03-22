function extractText() {
  const ul = document.getElementById("items");
  const arr = Array.from(ul.children);
  const field = document.getElementById('result');  

  for (const e of arr) {
    field.textContent += e.textContent + '\n';
  }
}
