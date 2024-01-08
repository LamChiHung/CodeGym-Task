function showHideList() {
    let list = document.querySelectorAll(".person-body-container-nav-body-item2-item-listItem");
    if (list[0].style.display == "none" || list[0].style.display == "") {
        console.log(list[0].style.display);
        list.forEach(element => {
            element.style.display = "flex";
        });
    } else {
        console.log(list[0].style.display);
        list.forEach(element => {
            element.style.display = "none";
        });
    }
}