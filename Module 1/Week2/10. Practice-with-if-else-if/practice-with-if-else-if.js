let user = prompt("input your username");
if (user == "Admin") {
    let password = prompt("input your password");
    if (password == "TheMaster") {
        alert("Welcome");
    }
    else if (password == "") {
        alert("Canceled");
    }
    else {
        alert("Wrong password");
    }
} else if (user == "") {
    alert("Canceled");
}
else {
    alert("I don't know you");
}