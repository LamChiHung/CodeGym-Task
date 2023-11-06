function sum() {
    let number1 = parseInt(document.getElementById("number1").value);
    let number2 = parseInt(document.getElementById("number2").value);
    let result = number1 + number2;
    document.getElementById("p").innerHTML = "result = "+ result;
}

function subtract() {
    let number1 = parseInt(document.getElementById("number1").value);
    let number2 = parseInt(document.getElementById("number2").value);
    let result = number1 - number2;
    document.getElementById("p").innerHTML = "result = "+ result;
}

function multi() {
    let number1 = parseInt(document.getElementById("number1").value);
    let number2 = parseInt(document.getElementById("number2").value);
    let result = number1 * number2;
    document.getElementById("p").innerHTML = "result = "+ result;
}

function divide() {
    let number1 = parseInt(document.getElementById("number1").value);
    let number2 = parseInt(document.getElementById("number2").value);
    let result = number1 / number2;
    document.getElementById("p").innerHTML = "result = "+ result;
}

