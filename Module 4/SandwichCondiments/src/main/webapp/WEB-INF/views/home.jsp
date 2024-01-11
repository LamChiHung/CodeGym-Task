<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 1/11/2024
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0"/>
    <title>Document</title>
</head>
<body>
<form action="/result" method="get">
    <input type="checkbox" id="lettuce"
           name="condiment1"
           value="lettuce">
    <label for="lettuce">Lettuce</label>
    <input type="checkbox" id="tomato"
           name="condiment2"
           value="tomato">
    <label for="tomato">Tomato</label>
    <input type="checkbox" id="mustard"
           name="condiment3"
           value="mustard">
    <label for="mustard">Mustard</label>
    <input type="checkbox" id="sprouts"
           name="condiment4"
           value="sprouts">
    <label for="sprouts">Sprouts</label>
    <button type="submit">Save</button>
</form>
</body>
</html>
