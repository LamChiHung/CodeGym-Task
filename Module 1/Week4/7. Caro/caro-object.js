function Td(id) {
    this.id = id;
    this.width = "50px";
    this.height = "50px";
    this.status = "";
    this.border = "1px solid black";


    this.setStatus = function (x) {
        if (this.status == "") {
            if (x % 2 == 0) {
                document.getElementById(this.id).textContent = "X";
                this.status = "X";
                return true;
            } else {
                document.getElementById(this.id).textContent = "O";
                this.status = "O";
                return true;
            }

        } else {
            alert("this cell had value");
            return false;
        }
    }

}

function Table() {

    this.turn = 0;
    this.createTds = function () {
        let tds = [];
        for (let i = 0; i < 10; i++) {
            tds[i] = [];
            for (let j = 0; j < 10; j++) {
                let td = new Td("td" + i + "" + j)
                tds[i][j] = td;
            }
        }
        return tds;
    }

    this.tds = this.createTds();

    this.createTable = function () {
        let table = document.createElement("table");
        table.style.borderCollapse = "collapse";
        table.id = "table";
        document.body.appendChild(table);

        for (let i = 0; i < 10; i++) {
            let tr = document.createElement("tr");
            table.appendChild(tr);
            for (let j = 0; j < 10; j++) {
                let td = document.createElement("td");
                td.style.border = this.tds[i][j].border;
                td.style.width = this.tds[i][j].width;
                td.style.height = this.tds[i][j].height;
                td.style.textAlign = "center";
                td.id = this.tds[i][j].id;
                td.onclick = () => {
                    if (this.tds[i][j].setStatus(this.turn)) {
                        this.turn++;
                    }
                };
                tr.appendChild(td);
            }
        }
    }
}

function win() {
    for (let i = 0; i < 10; i++) {
        for (let j = 0; j < 10; j++) {
            if (i > 7) {
                if (board.tds[i][j].status == "X" &&
                    board.tds[i][j + 1].status == "X" &&
                    board.tds[i][j + 2].status == "X" &&
                    board.tds[i][j + 3].status == "X" &&
                    board.tds[i][j + 4].status == "X") {
                    alert("X win")
                }
                else if (board.tds[i][j].status == "O" &&
                    board.tds[i][j + 1].status == "O" &&
                    board.tds[i][j + 2].status == "O" &&
                    board.tds[i][j + 3].status == "O" &&
                    board.tds[i][j + 4].status == "O") {
                    alert("O win")
                }
            }
            else if (j > 7) {
                if (board.tds[i + 0][j].status == "X" &&
                    board.tds[i + 1][j].status == "X" &&
                    board.tds[i + 2][j].status == "X" &&
                    board.tds[i + 3][j].status == "X" &&
                    board.tds[i + 4][j].status == "X") {
                    alert("X win")
                }
                else if (board.tds[i + 0][j].status == "O" &&
                    board.tds[i + 1][j].status == "O" &&
                    board.tds[i + 2][j].status == "O" &&
                    board.tds[i + 3][j].status == "O" &&
                    board.tds[i + 4][j].status == "O") {
                    alert("O win")
                }
            } else {
                if (
                    board.tds[i + 0][j].status == "X" &&
                    board.tds[i + 1][j].status == "X" &&
                    board.tds[i + 2][j].status == "X" &&
                    board.tds[i + 3][j].status == "X" &&
                    board.tds[i + 4][j].status == "X" ||
                    board.tds[i][j].status == "X" &&
                    board.tds[i][j + 1].status == "X" &&
                    board.tds[i][j + 2].status == "X" &&
                    board.tds[i][j + 3].status == "X" &&
                    board.tds[i][j + 4].status == "X") {
                    alert("X win")
                }
                else if (board.tds[i + 0][j].status == "O" &&
                    board.tds[i + 1][j].status == "O" &&
                    board.tds[i + 2][j].status == "O" &&
                    board.tds[i + 3][j].status == "O" &&
                    board.tds[i + 4][j].status == "O" ||
                    board.tds[i][j].status == "O" &&
                    board.tds[i][j + 1].status == "O" &&
                    board.tds[i][j + 2].status == "O" &&
                    board.tds[i][j + 3].status == "O" &&
                    board.tds[i][j + 4].status == "O") {
                    alert("O win")
                }
            }
        }
    }
}
let board = new Table();
board.createTds();
board.createTable();
window.addEventListener("click", win);
