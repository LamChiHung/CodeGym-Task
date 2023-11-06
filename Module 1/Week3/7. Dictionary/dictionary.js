let english = [];
let vietnamese = [];

function add() {
    let a = document.getElementById("english");
    let b = document.getElementById("vietnamese");
    english.push(a.value);
    vietnamese.push(b.value);
    alert("Inserting new word is successful!===> English: "+ a.value +" | Vietnamese: "+ b.value);
}

function search() {
    let keyword = document.getElementById("keyword");
    let index = english.indexOf(keyword.value);
    if (index >= 0) {
        document.getElementById("result").innerHTML = "Result: "+ vietnamese[index];
    }
}

