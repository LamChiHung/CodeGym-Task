function calculator() {
    let w = parseFloat(document.getElementById("weight").value);
    let h = parseFloat(document.getElementById("height").value);
    let bmi = w / (h * h);
    if (bmi < 18.5) {
        document.getElementById("result").innerHTML = "BMI: " + bmi.toFixed(2) + " Underweight";
    }
    else if (18.5 <= bmi && bmi < 25) {
        document.getElementById("result").innerHTML = "BMI: " + bmi.toFixed(2) + " Normal";
    }
    else if (25 <= bmi && bmi < 30) {
        document.getElementById("result").innerHTML = "BMI: " + bmi.toFixed(2) + " Overweight";
    }
    else if (30 <= bmi) {
        document.getElementById("result").innerHTML = "BMI: " + bmi.toFixed(2) + " Obese";
    }
}