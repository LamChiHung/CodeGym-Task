// Bài 1. Tính điểm trung bình và tổng các môn học
function insert_grade() {
    let p = parseInt(prompt("Insert physical grade"));
    let c = parseInt(prompt("Insert chemical grade"));
    let b = parseInt(prompt("Insert biology grade"));

    let average = ((p + c + b) / 3);
    let sum = p + c + b;

    document.getElementById("average").innerHTML = average;
    document.getElementById("sum").innerHTML = sum;
}

// Bài 2. Chuyển đổi độ C sang độ F
function convert() {
    let doC = document.getElementById("c").value;
    let doF = (doC * 9) / 5 + 32;
    document.getElementById("f").innerHTML = "result: " + doF + " F degree";
}

// Bài 3. Tính diện tích và chu vi hình tròn
function calculation() {
    let r = document.getElementById("r").value;
    let area = Math.PI * r * r;
    let perimeter = 2 * Math.PI * r;

    document.getElementById("area").innerHTML = "area = " + area;
    document.getElementById("perimeter").innerHTML = "perimeter = " + perimeter;
}

