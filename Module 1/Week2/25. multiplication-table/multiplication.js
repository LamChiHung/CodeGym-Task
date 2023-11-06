let a = "<table border = '1px' width = '300'>"
for (let i = 2; i <= 9; i++) {
    a = a + "<tr>"
    for (let j = 1; j <= 9; j++) {
    a = a + "<td>" + i + "x" + j + "=" + i*j +"</td>"
    }
    a = a + "</tr>"
}
a = a + "</table>"
document.write(a);