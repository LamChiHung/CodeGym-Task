let canvas = document.getElementById("myCanvas");
canvas.width = window.innerWidth-200;
canvas.height = window.innerHeight-200;

function Rectangle(width, height) {
    this.width = width;
    this.height = height;

    this.setRect = function (width, height) {
        this.width = width;
        this.height = height;
    }

    this.area = function () {
        let area = this.width * this.height;
        return area;
    }

    this.perimeter = function () {
        let perimeter = 2 * (this.width + this.height);
        return perimeter;
    }

    this.draw = function () {
        let canvas = document.getElementById("myCanvas");
        let context = canvas.getContext('2d');

        context.beginPath();
        context.rect(0, 0, this.width, this.height);
        context.fill();

    }

}

let rec = new Rectangle(200,200);
rec.setRect(500,500);
rec.draw();
document.getElementById("view").innerHTML = rec.area() + " / " + rec.perimeter();