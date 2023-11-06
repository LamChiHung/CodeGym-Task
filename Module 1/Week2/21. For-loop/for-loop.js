// Bài 1
for (let i = 0; i < 5; i++) {
    let p = document.getElementById("p")
     p.innerHTML += "the number is "+ i +"<br>";
}

// Bài 2
let n = prompt("Nhập số n");
let result = 0;
for (let i = 1; i <= n; i++) {
   result += i;
}
alert(result)
