function Battery() {
    this.energy;
    this.setEnergy = function (energy) {
        this.energy = energy;
    }
    this.getEnergy = function () {
        return this.energy;
    }
    this.decreaseEnergy = function () {
        if (this.energy > 0) {
            this.energy--;
        }
    }
}

function Flashlight(battery) {
    this.battery;
    this.status = false;
    this.setBattery = function () {
        this.battery = battery;
    }
    this.getBatteryInfo = function () {
        return this.battery.getEnergy();
    }
    this.checkStatus = function (turn) {
        if (this.status) {
            alert("ON");
        } else {
            alert("OFF");
        }
        battery.decreaseEnergy();
    }
    this.turn = function () {
        if (this.status) {
            this.status = false;
        } else {
            this.status = true;
        }
        battery.decreaseEnergy();
    }
}

let battery = new Battery();
let flash = new Flashlight(battery);

battery.setEnergy(90);
document.write(battery.getEnergy()+"<br>");

flash.turn();
flash.checkStatus();

flash.setBattery();
document.write(flash.getBatteryInfo());

