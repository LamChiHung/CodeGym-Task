function Circle() {
    this.x = Math.random() * document.getElementById("circles").offsetWidth;
    this.y = Math.random() * document.getElementById("circles").offsetHeight
    this.radius = Math.random()*80;

    this.createCircle = function () {
        let context = document.getElementById("circles").getContext("2d");
        context.beginPath();
        let color = this.randomColor();
        context.arc(this.x, this.y, this.radius, 0, 2 * Math.PI);
        context.fillStyle = color;
        context.fill();
    }

    this.randomColor = function () {
        let red = Math.floor(Math.random() * 255);
        let green = Math.floor(Math.random() * 255);
        let blue = Math.floor(Math.random() * 255);

        return "RGB(" + red + "," + green + "," + blue + ")";
    }

}

function multiplyCircle() {
    for (let i = 0; i < 40; i++) {
        let i  = new Circle;
        i.createCircle();
    }
}
multiplyCircle();