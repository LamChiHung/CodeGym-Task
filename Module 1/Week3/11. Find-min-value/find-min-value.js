let arr1 = [3, 5, 1, 8, -3, 7, 8];
let arr2 = [7, 12, 6, 9, 20, 56, 89];
let arr3 = [];
let arr4 = [0, 0, 0, 0, 0, 0];

function findMin(arr) {
    let min = arr[0];
    let position = -1;
    for (let i = 0; i < arr.length ; i++) {
        if (min > arr[i]) {
            min = arr[i];
            position = i;
        }
    }
    return position;
}

document.write("The index of min value of arr1 = [3, 5, 1, 8, -3, 7, 8] is: "+ findMin(arr1)+"<br>");
document.write("The index of min value of arr2 = [7, 12, 6, 9, 20, 56, 89] is: "+ findMin(arr2)+"<br>");
document.write("The index of min value of arr3 = [] is: "+ findMin(arr3)+"<br>");
document.write("The index of min value of arr4 = [0, 0, 0, 0, 0, 0] is: "+ findMin(arr4)+"<br>");
