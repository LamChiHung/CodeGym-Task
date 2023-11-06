let board = [];
let x = prompt("Input the number of row board");
let y = prompt("Input the number of column board");
let turn = 0;

for (let i = 0; i < x; i++) {
    board[i] = [];
    for (let j = 0; j < y; j++) {
        board[i][j] = "(.)";
    }
}



function printBoard() {
    for (let i = 0; i < x; i++) {

        for (let j = 0; j < y; j++) {
            document.getElementById("board").innerHTML += board[i][j] + "  ";
        }
        document.getElementById("board").innerHTML += "<br>";

    }
}

function move() {
    let moveX = prompt("Input your row position");
    let moveY = prompt("Input your column position");

    if (moveX <= board[0].length && moveY <= board.length && board[moveX][moveY] != "O" && board[moveX][moveY] != "X") {
        turn++;
        if (turn % 2 == 0) {
            board[moveX][moveY] = "O";
        }
        else {
            board[moveX][moveY] = "X";
        }
    }
    else {
        alert("The position is not valid")
    }
    document.getElementById("board").innerHTML = "";
    printBoard();
    win();

}

function win() {
    for (let i = 0; i < x; i++) {
        for (let j = 0; j < y; j++) {
            if (board[i][j] == "O" && board[i][j + 1] == "O" && board[i][j - 1] == "O" || board[i][j] == "O" && board[i + 1][j] == "O" && board[i - 1][j] == "O") {
                alert("O win");
                break;
            } else if (board[i][j] == "X" && board[i][j + 1] == "X" && board[i][j - 1] == "X" || board[i][j] == "X" && board[i + 1][j] == "X" && board[i - 1][j] == "X") {
                alert("X win");
                break;
            }
        }

    }
}



window.onload = printBoard();
