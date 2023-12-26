const buyBtn = document.querySelectorAll(".js-place-button");

function showBuyTicket() {
    const modal = document.querySelector(".modal");
    modal.classList.add("open");
}

for (const buy1Btn of buyBtn) {
    buy1Btn.addEventListener("click", showBuyTicket);
}

function hideBuyTicket() {
    const modal = document.querySelector(".modal");
    modal.classList.remove("open");
}

const closeBuyTicket = document.querySelector(".js-modal-close");
closeBuyTicket.addEventListener("click", hideBuyTicket);

const menuBar = document.querySelector(".mobile-menu-bar");

menuBar.addEventListener("click",openCloseMenuBar);
function openCloseMenuBar(){
    let nav = document.querySelector("#nav");
    let computedStyle = window.getComputedStyle(nav);
    let display = computedStyle.getPropertyValue("display");
    let header = document.getElementById("header");
    if(display=="flex"){
        nav.style.display = "none";
        header.style.height = "46px";
    } else{
        nav.style.display = "flex";
        header.style.height = "fit-content";
    }
}