let Circle = function(radius, color){
    this.radius = radius;
    this.color = color;

    this.getRadius = function(){
        return this.radius;
    }

    this.getArea = function(){
        let area = Math.PI * this.radius * this.radius;
        return area.toFixed(2);
    }
}

let c1 = new Circle(2);
let radius = c1.getRadius();
let area = c1.getArea();
alert(radius + " / " + area);