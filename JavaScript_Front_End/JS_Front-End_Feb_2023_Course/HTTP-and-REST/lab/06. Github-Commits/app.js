function loadCommits() {
  const BASE_URL = "https://api.github.com/repos/";
  const user = document.getElementById("username").value;
  const repo = document.getElementById("repo").value;
  const ul = document.getElementById('commits');

  let url = BASE_URL + user + "/" + repo + '/commits';

  fetch(url, {method:'GET'})
    .then((res) => res.json())
    .then((data) => {
        
     for (const rep of data) {
        let li = document.createElement('li');
        li.textContent = rep.commit.author.name + ': ' + rep.commit.message;
        ul.appendChild(li);
     }
    })
    .catch((err) => {
      document.getElementsByTagName('html')[0].textContent = url + ' Error 404 Not Found!';
    });
}
