function focused() {
    const sections = Array.from(document.querySelectorAll('div div input'));

    sections.forEach(s => {
        s.addEventListener('focus', focusOn);
        s.addEventListener('focusout', focusOut);
    });

    function focusOn(e) {
        let inp = e.currentTarget;
        
        const div = inp.parentElement;
        div.style = 'background-color:gray';
    }
    
    function focusOut(e) {
        let inp = e.currentTarget;
        
        const div = inp.parentElement;
        div.style = 'background-color:white';
    }
}