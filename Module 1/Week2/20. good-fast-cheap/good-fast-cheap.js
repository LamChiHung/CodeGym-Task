function checked() {
    let good = document.getElementById("good");
    let fast = document.getElementById("fast");
    let cheap = document.getElementById("cheap");
    
    if (good.checked && fast.checked) {
        cheap.checked = false;
    }
    else if (fast.checked && cheap.checked) {
        good.checked = false;
    }
    else if (cheap.checked && good.checked) {
        fast.checked = false;
    }
}
window.addEventListener("click",checked);