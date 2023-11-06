function leap_year() {
    let year = document.getElementById("year").value;
    let a = true;

    if (year % 4 === 0) {
        if (year % 100 !== 0) {
            a = true;
        }
        else {
            a = false;
        }
    }
    else if (year % 100 === 0) {
        if (year % 400 !== 0) {
            a = false;
        }
        else {
            a = true;
        }
    }
    else if (year % 100 === 0) {
        if (year % 400 === 0) {
            a = true;
        }
        else {
            a = false;
        }
    }
    else {
        a = false;
    }

    if (a===true){
        document.getElementById("result").innerHTML = "Leap Year";
    }
    else{
        document.getElementById("result").innerHTML = "Not Leap Year";
    }







}