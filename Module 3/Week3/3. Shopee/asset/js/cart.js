let plusButtons = document.querySelectorAll(".plusButton");
let minusButtons = document.querySelectorAll(".minusButton");
let quantityValue = document.querySelectorAll(".quantityValue");


for (let index = 0; index < plusButtons.length; index++) {
    plusButtons[index].addEventListener("click", function (event) {
        let buttonClicked = event.target;
        let parentButtonClicked = buttonClicked.parentElement;
        let quantity = parentButtonClicked.children[1];
        if (Number.parseInt(quantity.value) < 1000) {
            quantity.value = (Number.parseInt(quantity.value) + 1);
        }
        console.log(quantity);

        calculator(parentButtonClicked, quantity);
    })
}
for (let index = 0; index < minusButtons.length; index++) {
    minusButtons[index].addEventListener("click", function (event) {
        let buttonClicked = event.target;
        let parentButtonClicked = buttonClicked.parentElement;
        let quantity = parentButtonClicked.children[1];
        if (Number.parseInt(quantity.value) > 0) {
            quantity.value = (Number.parseInt(quantity.value) - 1);
        }
        console.log(quantity);
        calculator(parentButtonClicked,quantity);
    })
}

for (let index = 0; index < quantityValue.length; index++) {
    quantityValue[index].addEventListener("blur", function (event) {
        let buttonClicked = event.target;
        let parentButtonClicked = buttonClicked.parentElement;
        let quantity = parentButtonClicked.children[1];
        if (Number.parseInt(quantity.value) > 999) {
            quantity.value = 999;
        }
        console.log(quantity);
        calculator(parentButtonClicked,quantity);
    })
}

function calculator(parentButtonClicked, quantity) {
    let rowContent = parentButtonClicked.parentElement.parentElement;
    console.log(rowContent);
    let originPrice = rowContent.children[2].children[1].children[1].textContent;
    let rowTotalPriceValue = Number.parseInt(originPrice) * Number.parseInt(quantity.value);
    let rowTotalPrice = rowContent.children[4].children[1];
    rowTotalPrice.textContent = rowTotalPriceValue;
}



