function Phone() {
    this.battery = 100;
    this.message = "";
    this.messageSend = [];
    this.messageReceive = [];
    this.status = true;

    this.checkOnOff = function () {
        if (this.status) {  
            document.write("Phone is on"+"<br>");
            this.battery--;
        }
        else{
            document.write("Phone is off"+"<br>");
            this.battery--;
        }
    }

    this.turnOnOff = function (x) {
        if (x == "on") {
            this.battery--;
            this.status = true;
        } else if (x == "off") {
            this.battery--;
            this.status = false;
        } else {
            this.battery--;
            document.write("Status is not valid"+"<br>");
        }
    }

    this.charge = function () {
        this.battery = 100;
    }

    this.Message = function (text) {
        this.message = text;
        this.battery--;
    }

    this.receiveMessage = function () {
        this.battery--;
        document.write(this.messageReceive + "<br>");

    }

    this.sendMessage = function (name) {
        name.messageReceive.push(this.message);
        this.messageSend.push(this.message);
        this.battery--;
    }
    this.viewMessageSend = function () {
        document.write(this.messageSend + "<br>");;
    }
}

let nokia = new Phone();
let iphone = new Phone();

nokia.checkOnOff();
nokia.turnOnOff("off");
nokia.checkOnOff();
document.write(nokia.battery +"<br>");
nokia.Message("Hello");
nokia.sendMessage(iphone);
nokia.viewMessageSend();
iphone.receiveMessage();
nokia.charge();
document.write(nokia.battery +"<br>");




