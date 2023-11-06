function moveUp() {
    let img = document.getElementById('img');
    img.style.top = parseInt(img.style.top) - 5 + "px";
}

function moveDown() {
    let img = document.getElementById('img');
    img.style.top = parseInt(img.style.top) + 5 + "px";
}

function moveLeft() {
    let img = document.getElementById("img");
    img.style.left = parseInt(img.style.left) - 5 + "px";
}

function moveRight() {
    let img = document.getElementById('img');
    img.style.left = parseInt(img.style.left) + 5 + "px";
}


function move(evt) {
    switch (evt.keyCode) {
        case 37:
            moveLeft();
            break;
        case 39:
            moveRight();
            break;
        case 38:
            moveUp();
            break;
        case 40:
            moveDown();
            break;
        default:
            break;
    }
}


function controller() {
    let img = document.getElementById("img");
    img.style.position = "relative";
    img.style.width = "10%";
    img.style.left = "0px";
    img.style.top = "0px";
}
window.onload = controller();
window.addEventListener('keydown', move)