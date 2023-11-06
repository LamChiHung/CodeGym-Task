let array = [-3, 5, 1, 3, 2, 10];
let max = array[0];
for (let i = 0; i < array.length; i++) {
    if (max < array[i]) {
        max = array[i];
    }
}
document.getElementById("result").innerHTML = "The max value in array is: "+ max;