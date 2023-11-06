function run() {
    let i = 10;
    let f = 20.5;
    let b = true;
    let s = "Hồ Chí Minh";
    let width = 20;
    let height = 10;
    let area = width * height;

    let x = prompt();
    let y = prompt();
    let z = x % y;


    document.write("i="+i+"<br>" );
   
    document.write("f="+f+"<br>");
    
    document.write("b="+b+"<br>");
  
    document.write("s="+s+"<br>");

    document.write("Area=" + area+"<br>");

    alert(z);

    }
