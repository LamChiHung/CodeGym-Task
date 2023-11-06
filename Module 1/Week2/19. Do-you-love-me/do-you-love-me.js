function yes() {
    alert("Love you too!")
}
function no() {
    let no = document.getElementById("no");
    no.style.left = (Math.random() * window.innerWidth) + "px";
    no.style.top = (Math.random() * window.innerHeight) + "px";
}