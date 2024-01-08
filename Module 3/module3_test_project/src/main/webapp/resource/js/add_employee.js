let formSelect = document.querySelector(".form-select");
let departmentInput = document.getElementById("department");
formSelect.addEventListener("click", changeDepartmentValue);

function changeDepartmentValue() {
    departmentInput.value = formSelect.value;
    console.log(departmentInput.value);
}