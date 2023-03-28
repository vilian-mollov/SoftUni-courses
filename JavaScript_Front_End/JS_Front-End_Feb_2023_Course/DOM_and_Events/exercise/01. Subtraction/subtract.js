function subtract() {
    const firstNumber = document.getElementById('firstNumber');
    const secondNumber = document.getElementById('secondNumber');
    const divResult = document.getElementById('result');

    let result = Number(firstNumber.value) - Number(secondNumber.value);

    divResult.textContent = result;
}