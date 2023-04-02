function loadRepos() {
  const url = "https://api.github.com/users/";
  const user = document.getElementById('username').value;
  const ul = document.getElementById('repos');
  
  const li = document.querySelector('ul li');
  ul.removeChild(li);

  fetch(url + user + '/repos', {method:'GET'})
  	.then((res) => res.json())
  		.then((data) => {
			
			for (const repo of data) {
				const li = document.createElement('li');
				const a = document.createElement('a');
				a.href = 'https://github.com/' + user + '/' +repo.name;
				a.textContent = user + '/' + repo.name;
				li.appendChild(a);
				ul.appendChild(li);
			}
			
		})
  .catch((err) => {
	const html  = document.getElementsByTagName('html')[0];
	html.textContent = "https://api.github.com/users/" + user + '/repos' + '  status: 404 Not Found';
  });
}
