// Bài 1
function alertMessage(){
    alert("Hello");
}
alertMessage();

// Bài 2
let x = parseInt(prompt("Input the number"));
function increasing(x) {
    let result = x + 1;
    return result;
}
alert(increasing(x));

// Bài 3
let a = parseInt(prompt("Input first number"));
let b = parseInt(prompt("Input second number"));

function ex3(a,b) {
    let result;
    if (a > b) {
        return result = a + " > "+ b;
    } else {
        return result = a + b;
    }
}
alert(ex3(a,b));

// Bài 4
function addNumbers() {
    firstNum = 4;
    secondNum = 8;
    result = firstNum + secondNum;
    return result;
}
result = 0;
alert(result);
result = addNumbers();
alert(result);

// Bài 5
let arr1 = ["Polaris", "Aldebaran", "Deneb", "Vega", "Altair", "Dubhe", "Regulus"];
let arr2 = ["Ursa Minor", "Taurus", "Cygnus", "Lyra", "Aquila", "Ursa Major", "Leo"];
let starName = prompt("Input the star name");
function check(name) {
    let result;
    for (let i = 0; i < arr1.length; i++) {
        if (name == arr1[i]) {
            return result = arr2[i];
        }
    }
    return result = "The name is not valid";
}
alert(check(starName));
