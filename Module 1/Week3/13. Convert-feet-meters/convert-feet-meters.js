function feetToMeters() {
    let f = document.getElementById("feet").value;
    let r = 0.305 * f;
    document.getElementById("metersResult").innerHTML = "feet to meter: "+ r;
}
function metersToFeet() {
    let m = document.getElementById("meters").value;
    let r = 3.279 * m;
    document.getElementById("feetResult").innerHTML = "meters to feet: "+ r;
}