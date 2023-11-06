class Animal {
    constructor(id, name) {
        this.id = id;
        this.name = name;
    }
    get getId(){
        return this.id;
    }
    set setId(id){
        this.id = id
    }
    get getName() {
        return this.name;
    }
    set setName(name) {
        this.name = name
    }
}

class Cat extends Animal {
    constructor(id, name, color){
        super(id,name)
        this.color = color;
    }
    get getColor() {
        return this.color;
    }
    set setColor(name) {
        this.color = color;
    }
}

let animal = new Animal(1, "Animal");
let cat = new Cat("Yellow");