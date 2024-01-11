<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 1/11/2024
  Time: 5:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Submitted Employee Information</h2>
<table>
    <tr>
        <td>Name:</td>
        <td>${employee.getName()}</td>
    </tr>
    <tr>
        <td>ID:</td>
        <td>${employee.getId()}</td>
    </tr>
    <tr>
        <td>Contact Number:</td>
        <td>${employee.getContactNumber()}</td>
    </tr>
</table>
</body>
</html>
