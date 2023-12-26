function increaseQuantity() {
    let quantity = document.querySelector(".cart-body-container-header-quantity-container input");
    if (Number.parseInt(quantity.value) < 1000) {
        quantity.value = (Number.parseInt(quantity.value) + 1);
    }

}
function decreaseQuantity() {
    let quantity = document.querySelector(".cart-body-container-header-quantity-container input");
    if (Number.parseInt(quantity.value) > 0) {
        quantity.value = (Number.parseInt(quantity.value) - 1);
    }
}

function checkQuantity() {
    let quantity = document.querySelector(".cart-body-container-header-quantity-container input");
    if (Number.parseInt(quantity.value) > 999) {
        quantity.value = 999;
    }
}