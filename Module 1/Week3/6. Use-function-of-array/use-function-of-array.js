let myColor = ["Red", "Green", "White", "Black"];
// Bài 1

document.getElementById("ex1").innerHTML = myColor.join();

// Bài 2
let arrayNumber = []
let numbers = prompt("Input sequence of numbers");
let stringNumber = numbers.toString();
for (let i = 0; i < stringNumber.length; i++) {
    arrayNumber[i] = stringNumber.charAt(i);
}

for (let i = 1; i < arrayNumber.length; i++) {
    if (arrayNumber[i - 1] % 2 == 0 && arrayNumber[i] % 2 == 0) {
        arrayNumber.splice(i + 1, 0, "-");
    }

}
if (arrayNumber[arrayNumber.length - 2] % 2 == 0 && arrayNumber[arrayNumber.length - 3] % 2 == 0) {
    arrayNumber.pop();
}
document.getElementById("ex2").innerHTML = arrayNumber.join(" ");

// Bài 3
let exString = "The Quick Brown Fox";
let upper = "QWERTYUIOPASDFGHKLZXCVBNM";
let lower = "qwertyuiopasdfghjklzxcvbnm";
let space = " ";
let exStringChange = "";
for (let i = 0; i < exString.length; i++) {
    let c = exString.charAt(i);
    if (upper.indexOf(c) >= 0) {
        exStringChange += c.toLowerCase();
        ;
    }
    else if (lower.indexOf(c) >= 0) {
        exStringChange += c.toUpperCase();
    }
    else if (space.indexOf(c) >= 0) {
        exStringChange += " ";
    }
}
document.getElementById("ex3").innerHTML = exStringChange;




