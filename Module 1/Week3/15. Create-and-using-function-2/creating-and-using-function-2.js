// Bài 1
let x = parseInt(prompt("Ex1: Input the number"));
function sqr(x) {
    let result = x * x;
    return result;
}
alert(sqr(x));

//Bài 2
function area(r) {
    let area = 3.14 * r * r;
    return area;
}
function perimeter(r) {
    let perimeter = 2 * 3.14 * r;
    return perimeter;
}
alert(area(x));
alert(perimeter(x));

// Bài 3
function factorial(x) {
    let result = 1;
    for (let i = 1; i <= x; i++) {
        result *= i;
    }
    return result;
}
alert(factorial(x));

//Bài 4
function check(x) {
    let check = Number.isNaN(x);
    let result = "";
    if (check) {
        result = "Is not a number";
    }
    else {
        result = "Is a number";
    }
    return result;
}
alert(check(x));

// Bài 5
let a = parseInt(prompt("Input the first number"));
let b = parseInt(prompt("Input the second number"));
let c = parseInt(prompt("Input the third number"));

function min(a, b, c) {
    let array = [a, b, c];
    let min = a;
    for (let i = 0; i < array.length; i++) {
        if (min > array[i]) {
            min = array[i]
        }
    }
    return min;
}
alert(min(a, b, c));

// Bài 6
function checkInt(x) {
    if (x > 0) {
        if (Number.isInteger(x)) {
            return true;
        } else {
            return false;
        }
    }
    else {
        return false;
    }
}
alert(checkInt(x));

// Bài 7
function swap(a, b) {
    let array = [a, b];
    array.reverse();
    let result = array.join();
    return result;
}
alert(swap(a, b));

// Bài 8
let ex8 = [1, 2, 3, 4, 5, 6, 7];
function swapArray(array) {
    let result = [];
    let j = 0;
    for (let i = array.length - 1; i >= 0; i--) {
        result[j] = array[i];
        j++;
    }
    return result;
}
alert(swapArray(ex8));

// Bài 9
let char = ["a", "b", "a", "d", "a", "f", "g", "h"];
let d = prompt("Input the char");
function countChar(c) {
    let count = 0;
    for (let i = 0; i < char.length; i++) {
        if (c == char[i]) {
            count++;
        }
    }
    if (count == 0) {
        return count = -1;
    }
    else {
        return count;
    }
}
alert(countChar(d));