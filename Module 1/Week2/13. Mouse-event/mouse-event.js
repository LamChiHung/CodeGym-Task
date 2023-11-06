function init() {
    let img = document.getElementById('img');
    img.style.position = "relative";
    img.style.width = "25%";
    img.style.left = "0px";
}

function moveRight() {
    let img = document.getElementById('img');
    img.style.left = parseInt(img.style.left)+10+"px";
}


window.onload = init();