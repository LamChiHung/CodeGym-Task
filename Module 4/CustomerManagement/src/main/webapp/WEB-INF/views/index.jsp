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
<table>
    <thead>
    <tr>
        <th>Email</th>
        <th>Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customers}"
               var="customer">
        <tr>
            <td>${customer.getEmail()}</td>
            <td>${customer.getName()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>