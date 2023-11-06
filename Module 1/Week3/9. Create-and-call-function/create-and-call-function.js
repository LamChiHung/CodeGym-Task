let ask = confirm("Let play game!");
function answer(x) {
    let result;
    if (x) {
        result = "We will have a nice game";
    }
    else {
        result = "Maybe later!";
    }
    return result;
}

alert(answer(ask));