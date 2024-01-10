<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/convert/submit">
    <input name="usd" type="text">
    <p>${vnd}</p>
    <button type="submit">Convert</button>
</form>


</body>
</html>