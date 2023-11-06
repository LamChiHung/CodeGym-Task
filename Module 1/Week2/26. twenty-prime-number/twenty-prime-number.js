let n = prompt("Input quantity of prime number");
let count = 0;
let j
let result = "";
if (n == 1) {
    document.write("2");
}
else {
    document.write("2 <br>");
    count++;
    for (let i = 3; count < n; i++) {
        for (let j = 2; j < i; j++) {
            if (i % j == 0) {
                break;
            }
            else if (i - j == 1) {
                result = result + i + "<br>";
                count++;
            }
        }
    }
}
document.write(result);
