let arrayBefore = [-3, 5, 1, 3, 2, 10];
let arrayAfter = [];
let j = arrayBefore.length-1;
document.getElementById("before").innerHTML = arrayBefore;
for (let i = 0; i < arrayBefore.length; i++) {
    arrayAfter[i] = arrayBefore[j];
    j--;
}
document.getElementById("after").innerHTML = arrayAfter;