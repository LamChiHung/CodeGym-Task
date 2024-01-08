<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 1/8/2024
  Time: 9:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<c:set var="departmentList"
       value="${requestScope.departmentList}"/>
<c:set var="employee"
       value="${requestScope.employee}"/>

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
<form action="/edit" method="post">
    <input hidden="hidden"
           name="id"
           type="text"
           class="form-control"
           value="${employee.getId()}"
    />
    <div class="mb-3">
        <label for=""
               class="form-label">Name</label>
        <input
                name="name"
                type="text"
                class="form-control"
                value="${employee.getName()}"
        />
    </div>
    <div class="mb-3">
        <label for=""
               class="form-label">Email</label>
        <input
                name="email"
                type="email"
                class="form-control"
                value="${employee.getEmail()}"
        />
    </div>
    <div class="mb-3">
        <label for=""
               class="form-label">Address</label>
        <input
                name="address"
                type="text"
                class="form-control"
                value="${employee.getAddress()}"

        />
    </div>
    <div class="mb-3">
        <label for="" class="form-label">Phone
            number</label>
        <input
                name="phoneNumber"
                type="text"
                class="form-control"
                value="${employee.getPhoneNumber()}"
        />
    </div>
    <div class="mb-3">
        <label for=""
               class="form-label">Salary</label>
        <input
                name="salary"
                type="text"
                class="form-control"
                value="${employee.getSalary()}"
        />
    </div>
    <div class="mb-3">
        <label for="" class="form-label">Department</label>
        <input hidden="hidden"
               id="department"
               name="department"
               type="text"
               class="form-control"
               value="${employee.getDepartment()}"
        />
        <select class="form-select"
        >
            <c:forEach items="${departmentList}"
                       var="department">
                <option
                        value="${department.getName()}">${department.getName()}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">
        Submit
    </button>
</form>

<script src="/resource/js/edit_employee.js"></script>
</body>
</html>

