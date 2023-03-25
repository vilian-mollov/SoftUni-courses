function sumTable() {
    const prices = Array.from(document.
            querySelectorAll('table tbody tr td:nth-child(2)'));
    const total = document.getElementById('sum');    
    let sum = 0;    

    for (let i = 0; i < prices.length -1 ; i++) {
        sum += Number(prices[i].textContent);
    }

    total.textContent = sum;
}