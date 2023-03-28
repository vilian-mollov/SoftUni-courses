function toggle() {
    const btn = document.querySelector('#accordion .head span.button');
    const extra = document.getElementById('extra');
    
    if(extra.style.display === 'none' || extra.style.display === ''){
        btn.textContent = 'Less';
        extra.style.display = 'block';
    }else {
        btn.textContent = 'More';
        extra.style.display = 'none';
    }
}