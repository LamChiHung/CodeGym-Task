<%--
Created by IntelliJ IDEA.
User: Administrator
Date: 12/19/2023
Time: 11:33 AM
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String username = "";
    try {
        username = session.getAttribute("username").toString();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
%>

<p>Xin chào <%= username %>
</p>
<a href="trang1.jsp">Trang 1</a>
</body>
</html>
