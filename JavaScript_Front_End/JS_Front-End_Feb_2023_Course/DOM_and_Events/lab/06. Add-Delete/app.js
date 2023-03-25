function addItem() {
  const ul = document.getElementById("items");
  const input = document.getElementById("newItemText");

  const li = document.createElement("li");
  const anchor = document.createElement("a");
  anchor.href = "#"; //anchor.setAttribute(href="#"); <- Same
  anchor.textContent = "[DELETE]";
  anchor.addEventListener("click", deleteRow);

  li.textContent = input.value;
  li.appendChild(anchor);
  ul.appendChild(li);
  input.value = "";

  function deleteRow(e) {
    const anch = e.currentTarget;
    anch.parentNode.remove();
  }
}
