let product = "coffee";
let quantity = 2;

function calculatePrice(product, quantity) {
    let price = 0;
    switch(product) {
        case "coffee":
            price = 1.50;
            break;
        case "water":
            price = 1.00;
            break;
        case "coke":
            price = 1.40;
            break;
        case "snacks":
            price = 2.00;
            break;
    }

    return (price *  quantity).toFixed(2);
}

console.log(calculatePrice(product,quantity));

