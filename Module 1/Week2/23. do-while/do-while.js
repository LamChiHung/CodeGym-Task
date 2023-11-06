let a;
do {
    a = parseInt(prompt("Nhập số từ 0-10"));
} while (a < 0 || a > 10);
alert(`số bạn vừa nhập là: ${a}`);