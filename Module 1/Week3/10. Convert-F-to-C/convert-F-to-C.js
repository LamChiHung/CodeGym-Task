function change() {
    let F = document.getElementById("F").value;
    C = (F-32)/1.8;
    document.getElementById("C").innerHTML = "C degree: "+ C;
}