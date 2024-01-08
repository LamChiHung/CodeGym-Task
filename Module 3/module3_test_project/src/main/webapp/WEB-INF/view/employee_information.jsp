<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 1/8/2024
  Time: 8:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<c:set var="employeeList"
       value="${requestScope.employeeList}"/>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0"/>
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
</head>
<body>
<a class="btn btn-success" href="/employee?a=add">Add</a>
<form action="/employee" method="get">
    <input hidden="hidden" type="text" name="a"
           id=""
           value="search">
    <input type="text" name="name" id="">
    <button type="submit">Search</button>
</form>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Address</th>
        <th scope="col">PhoneNumber</th>
        <th scope="col">Salary</th>
        <th scope="col">Department</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employeeList}" var="e">
        <tr>
            <th scope="row">${e.getId()}</th>
            <td>${e.getName()}</td>
            <td>${e.getEmail()}</td>
            <td>${e.getAddress()}</td>
            <td>${e.getPhoneNumber()}</td>
            <td>${e.getSalary()}</td>
            <td>${e.getDepartment()}</td>
            <td>
                <a class="btn btn-primary"
                   href="/employee?a=edit&id=${e.getId()}">
                    Edit </a>
                <a class="btn btn-danger"
                   href="/employee?a=delete&id=${e.getId()}">
                    Delete </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="/resource/js/employee_information.js"></script>
</body>
</html>
