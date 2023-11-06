// Bài 1
let a = 0;
let sum = 0;
let sumText = "";
while (a!=-1) {
    a = parseInt(prompt("Nhập số a"));
    sum += a;
    sumText += "+ "+ a; 
    alert(sumText +"="+ sum);
}
// Bài 2 (Nhập a = -1 để chuyển sang bài 2)
let i=0;
while (i<100) {
    document.write("<hr width ="+i+"%>");
    i++
}