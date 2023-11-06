function Convert(c) {
    this.c = c;
    this.convertToF = function () {
        let f = c * (9 / 5) + 32;
        document.getElementById("fDegree").innerHTML = f + " độ F"
    }
    this.convertToK = function () {
        let k = c + 237.15;
        document.getElementById("kDegree").innerHTML = k + " độ K"
    }
}

function convert() {
    let c = new Convert(document.getElementById("cDegree").value);
    c.convertToF();
    c.convertToK();
}


