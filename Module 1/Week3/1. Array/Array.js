let array = [];
let result = document.getElementById("result");
function add() {
   array.push (document.getElementById("inputField").value);
   alert("input success!")
}
function display() {
    for (let i = 0; i < array.length; i++) {
        result.innerHTML = result.innerHTML +  "Element "+ i +" = " + array[i] + "<br>";
    }
}