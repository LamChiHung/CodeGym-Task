function convert() {
    let number = document.getElementById("number").value;
    let from = document.getElementById("from").value;
    let to = document.getElementById("to").value;

    if (from == to) {
        document.getElementById("result").innerHTML = number +" "+from;
    }
    else {
        if (from == "USD") {
            let result = number * 23000;
            document.getElementById("result").innerHTML = result +" VND";
        }
        else {
            let result = number / 23000;
            document.getElementById("result").innerHTML = result + " USD";
        }
    }
}