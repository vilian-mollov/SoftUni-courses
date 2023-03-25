function addItem() {
    const input = document.getElementById('newItemText');
    const list = document.getElementById('items');

    if( input.value != ''){
    const output = document.createElement("li");
    output.textContent = input.value;

    console.log(output.value);
    list.appendChild(output);
    
    input.value = '';
    }else{
        alert("You can't add empty text.");
    }
}