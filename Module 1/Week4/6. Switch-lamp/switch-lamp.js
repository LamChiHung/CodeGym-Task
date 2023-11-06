function Lamp() {
    this.status = false;
    this.turn = function () {
        if (this.status) {
            this.status = false;
            document.write("Lamp "+ this.status + "<br>");
        }
        else {
            this.status = true;
            document.write("Lamp "+ this.status + "<br>");

        }
    }
}

function Switch(lamp) {
    this.status = false;
    this.lamp = lamp;

    this.connectLamp = function (lamp) {
        this.lamp = lamp;
    }

    this.switch = function () {
        if (this.status) {
            this.status = false;
            this.lamp.turn();
            document.write("Switch " + this.status + "<br>")
        } else {
            this.status = true;
            this.lamp.turn();
            document.write("Switch " + this.status + "<br>")
        }
    }
}

let lamp1 = new Lamp();
let switch1 = new Switch(lamp1);

switch1.switch();
document.write("<hr>");
switch1.switch();
document.write("<hr>");
switch1.switch();
document.write("<hr>");
switch1.switch();
document.write("<hr>");
switch1.switch();
document.write("<hr>");
switch1.switch();
document.write("<hr>");
switch1.switch();
document.write("<hr>");
switch1.switch();
document.write("<hr>");
switch1.switch();
document.write("<hr>");
switch1.switch();
document.write("<hr>");
switch1.switch();

