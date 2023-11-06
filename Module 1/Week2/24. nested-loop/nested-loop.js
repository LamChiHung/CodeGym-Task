let a = "<table width = '300'>"
for (let i = 1; i <= 10; i++) {
    a = a + "<tr>";
    for (let j = 1; j <= 10; j++) {
        a = a + "<td>" + i*j + "</td>";
    }
    a = a + "</tr>"
}
a = a + "</table>"
document.write(a);