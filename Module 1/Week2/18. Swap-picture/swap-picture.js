let p1Monkey = "http://demo.codegym.vn/8/puzzlegame/img/monkey_part1x1.jpg";
let p2Monkey = "http://demo.codegym.vn/8/puzzlegame/img/monkey_part2x1.jpg";
let p3Monkey = "http://demo.codegym.vn/8/puzzlegame/img/monkey_part3x1.jpg";
let p4Monkey = "http://demo.codegym.vn/8/puzzlegame/img/monkey_part4x1.jpg";
let p5Monkey = "http://demo.codegym.vn/8/puzzlegame/img/monkey_part5x1.jpg";

let p1Panda = "http://demo.codegym.vn/8/puzzlegame/img/panda_swap_part1x1.jpg";
let p2Panda = "http://demo.codegym.vn/8/puzzlegame/img/panda_swap_part2x1.jpg";
let p3Panda = "http://demo.codegym.vn/8/puzzlegame/img/panda_swap_part3x1.jpg";
let p4Panda = "http://demo.codegym.vn/8/puzzlegame/img/panda_swap_part4x1.jpg";
let p5Panda = "http://demo.codegym.vn/8/puzzlegame/img/panda_swap_part5x1.jpg";

let p1Cat = "http://demo.codegym.vn/8/puzzlegame/img/funny-cat1_part1x1.jpg";
let p2Cat = "http://demo.codegym.vn/8/puzzlegame/img/funny-cat1_part2x1.jpg";
let p3Cat = "http://demo.codegym.vn/8/puzzlegame/img/funny-cat1_part3x1.jpg";
let p4Cat = "http://demo.codegym.vn/8/puzzlegame/img/funny-cat1_part4x1.jpg";
let p5Cat = "http://demo.codegym.vn/8/puzzlegame/img/funny-cat1_part5x1.jpg";

let p1 = document.getElementById("p1");
let p2 = document.getElementById("p2");
let p3 = document.getElementById("p3");
let p4 = document.getElementById("p4");
let p5 = document.getElementById("p5");

function swap1() {
    switch (p1.src) {
        case p1Monkey:
            p1.src = p1Panda;
            break;
        case p1Panda:
            p1.src = p1Cat;
            break;
        case p1Cat:
            p1.src = p1Monkey;
            break;
        default:
            break;
    }

}
function swap2() {
    switch (p2.src) {
        case p2Monkey:
            p2.src = p2Panda;
            break;
        case p2Panda:
            p2.src = p2Cat;
            break;
        case p2Cat:
            p2.src = p2Monkey;
            break;
        default:
            break;
    }

}
function swap3() {
    switch (p3.src) {
        case p3Monkey:
            p3.src = p3Panda;
            break;
        case p3Panda:
            p3.src = p3Cat;
            break;
        case p3Cat:
            p3.src = p3Monkey;
            break;
        default:
            break;
    }

}
function swap4() {
    switch (p4.src) {
        case p4Monkey:
            p4.src = p4Panda;
            break;
        case p4Panda:
            p4.src = p4Cat;
            break;
        case p4Cat:
            p4.src = p4Monkey;
            break;
        default:
            break;
    }

}
function swap5() {
    switch (p5.src) {
        case p5Monkey:
            p5.src = p5Panda;
            break;
        case p5Panda:
            p5.src = p5Cat;
            break;
        case p5Cat:
            p5.src = p5Monkey;
            break;
        default:
            break;
    }

}
function win() {
    if (p1.src==p1Cat && p2.src==p2Cat && p3.src==p3Cat && p4.src==p4Cat && p5.src == p5Cat) {
        alert("You win!");
    }
    if (p1.src==p1Monkey && p2.src==p2Monkey && p3.src==p3Monkey && p4.src==p4Monkey && p5.src == p5Monkey) {
        alert("You win!");
    }
    if (p1.src==p1Panda && p2.src==p2Panda && p3.src==p3Panda && p4.src==p4Panda && p5.src == p5Panda) {
        alert("You win!");
    }
}
window.addEventListener("click",win)