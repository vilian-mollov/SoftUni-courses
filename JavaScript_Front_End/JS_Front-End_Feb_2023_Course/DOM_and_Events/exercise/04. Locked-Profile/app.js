function lockedProfile() {
    const list = Array.from(document.querySelectorAll('#user1HiddenFields, #user2HiddenFields, #user3HiddenFields'));
    const user1 = list[0];
    const user2 = list[1];
    const user3 = list[2];

    const buttons = Array.from(document.getElementsByTagName('button'));
    buttons.forEach(b => {
        b.addEventListener('click', showMoreLess);
    });




    function showMoreLess(e) {
        const butt = e.currentTarget;
        const div = butt.parentNode;
        const children = [...div.children];
        const lock = children[2];
        const unlock = children[4];
        
        if(lock.checked){
            return;
        }
         const hidden = children[9];

         if(hidden.style.display === '') {
            hidden.style.display = 'block'
            butt.textContent = 'Show less'
         }else {
            hidden.style.display = ''
            butt.textContent = 'Show more'
         }
    
    }

}