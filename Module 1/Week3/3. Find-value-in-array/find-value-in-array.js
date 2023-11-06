let array = [-3, 5, 1, 3, 2, 10];
let a = parseInt(prompt("Input the value you want to find!"));
for (let i = 0; i < array.length; i++) {
    if (a==array[i]) {
        document.getElementById("result").innerHTML += "Position of value '"+ a + "' in array is: "+ i ;
        break;
    }
    else if (i== array.length-1){
        document.getElementById("result").innerHTML = "The value is not in the array";
    }
    
}