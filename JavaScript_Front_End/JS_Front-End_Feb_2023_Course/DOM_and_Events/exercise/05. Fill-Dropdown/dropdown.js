function addItem() {
    const text = document.getElementById('newItemText');
    const value = document.getElementById('newItemValue');
    const menu = document.getElementById('menu');

    const newOption = document.createElement('option');
    newOption.textContent = text.value;
    newOption.value = value.value;
    menu.appendChild(newOption);

    text.value = '';
    value.value = '';

}