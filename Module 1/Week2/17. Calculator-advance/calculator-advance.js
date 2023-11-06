function input(button) {
    let value = button;
    let view = document.getElementById("view");
    view.value = (document.getElementById("view").value + value.value);
}

function calculator() {
    document.getElementById("view").value = eval(document.getElementById("view").value);
}

function remove() {
    document.getElementById("view").value = "";
}