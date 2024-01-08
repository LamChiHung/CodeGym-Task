let closeButton = document.querySelector(".addProduct-container-form-cancel-button");
let cancelButton = document.querySelector(".addProduct-container-form-buttonGroup-cancel");
let submitButton = document.querySelector(".addProduct-container-form-buttonGroup-save");
let form = document.querySelector(".addProduct-container");
let addProductButton = document.querySelector(".product-container-buttonContainer-addButton");
let editProductButton = document.querySelectorAll(".product-container-row2-item-information-edit");

function closeForm() {
    form.style.display = "none";
    // console.log("a");
}

function openAddProductForm() {
    document.querySelector(".addProduct-container-form").reset();
    form.style.display = "flex";
    let a = document.querySelector("#a-form");
    a.value = "add";

}

closeButton.addEventListener("click", closeForm);
cancelButton.addEventListener("click", closeForm);

addProductButton.addEventListener("click", openAddProductForm);

editProductButton.forEach(element => {
    element.addEventListener("click", function(event){
        form.style.display = "flex";
        let a = document.querySelector("#a-form");
        a.value = "edit";
        let parent = event.target.parentElement.parentElement;

        document.getElementById("a-form").value = "edit";
        document.getElementById("product-id-form").value = parent.children[0].textContent.trim();
        document.getElementById("product-name-form").value = parent.children[2].textContent.trim();
        document.getElementById("category-form").value = parent.children[3].textContent.trim();
        console.log(document.getElementById("category-form"));
        document.getElementById("product-originPrice-form").value = parent.children[4].textContent.trim();
        document.getElementById("product-sellPrice-form").value = parent.children[5].textContent.trim();
        document.getElementById("product-sellPrice-form").value = parent.children[5].textContent.trim();
        document.getElementById("product-quantity-form").value = parent.children[6].textContent.trim();
        document.getElementById("product-urlAvatar-form").value = parent.children[1].children[0].src.trim();
    });
})
