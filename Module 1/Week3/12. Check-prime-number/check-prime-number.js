let number = parseInt(prompt("Input the number to check prime number"));
function check(x) {
    let result;
    if (x == 0 || x == 1) {
        return result = x + " is not prime number";
    }
    else if (x == 2) {
        return result = x + " is prime number";
    }
    for (let i = 2; i < x; i++) {
        if (x % i == 0) {
            return result = x + " is not prime number";
        }
        if (i + 1 == x) {
            return result = x + " is prime number";
        }
    }
}
alert(check(number));
