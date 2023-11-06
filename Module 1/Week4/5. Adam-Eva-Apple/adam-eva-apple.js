function Apple() {
    this.weight = 10;

    this.decrease = function () {
        if (this.isEmpty()) {
            this.weight--;
            return true;
        } else {
            return false;
        }
    }

    this.isEmpty = function () {
        if (this.weight > 0) {
            return true;
        } else {
            return false;
        }
    }

    this.getWeight = function () {
        document.write("Apple has: " + this.weight + " unit"+"<br>");
    }
}

function Human(name, gender, weight) {
    this.name = name;
    this.gender = gender;
    this.weight = weight;

    this.eat = function (x) {
        if (x.decrease()) {
            document.write(name + " eat apple"+"<br>");
            this.weight++;
            document.write(name + " weight: " + this.weight+"<br>");
            document.write("Apple weight: " + x.weight +"<br>");

        }
    }

    this.check = function (x) {
        document.write("Apple has: " + x.weight + " unit"+"<br>");
    }
}
let apple = new Apple();
let adam = new Human("Adam", "male", 70);
let eva = new Human("Eva", "female", 60);

adam.check(apple);
document.write("<hr>");
adam.eat(apple);
document.write("<hr>");
eva.eat(apple);