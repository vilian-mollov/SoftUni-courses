function deleteByEmail() {
    const result = document.getElementById("result");
    const email = document.querySelector('input[name="email"]').value;
    let secondColumn = Array.from(document.querySelectorAll("td:nth-child(even)"));

    let foundedEl = secondColumn.find((td) => td.textContent === email);

    if (foundedEl) {
      result.textContent = "Deleted.";
      foundedEl.parentNode.remove();
    } else {
      result.textContent = "Not found.";
    }

  }
  

