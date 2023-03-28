function create(words) {
   
   for (const word of words) {
      const content = document.getElementById('content');
      const div = document.createElement('div');
      const p = document.createElement('p');

      p.textContent = word;
      p.style.display ='none';
      div.appendChild(p);

      div.addEventListener("click", display);

      content.appendChild(div);

      function display(e) {
         e.currentTarget.firstChild.style.display = 'block';
      }
   }

}