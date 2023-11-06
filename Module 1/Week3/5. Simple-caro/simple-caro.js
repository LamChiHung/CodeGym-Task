let array = [];
let d = document.getElementById("board");
for (let i = 0; i < 5; i++) {
    array[i]= [];
    for (let j = 0; j < 5; j++) {
        array[i][j] = 0;
    }
}
function printBoard() {
    for (let i = 0; i < array.length; i++) {
        for (let j = 0; j < array.length; j++) {
           d.innerHTML += array[i][j] + "&nbsp";
        }
        d.innerHTML += "<br>";
    }
    document.getElementById("board").innerHTML;
}


function changeValue() {
    let x = parseInt(prompt("Input position X: "));
    let y = parseInt(prompt("Input position Y: "));
    if (x<array.length-1 && y<array[0].length-1) {
        array[x][y] = "x";
    }
    else{
        alert("The position is not valid")
    }
    d.innerHTML = "";
    printBoard();
}
window.onload = printBoard();
