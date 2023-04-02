function loadRepos() {
  const url = "https://api.github.com/users/testnakov/repos";

  fetch(url, {method: "GET"})
    .then((res) => res.text())
    .then((data) => {
      const result = document.getElementById("res");
      result.textContent = data;
    });

  


}
