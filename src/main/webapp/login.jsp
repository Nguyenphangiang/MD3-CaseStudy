<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/5/2022
  Time: 11:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Login Form</h1>
<form action="ResRestaurantServlet" method="post">
    <p>Tai khoan</p>
    <input type="text" name="account" placeholder="account"/><br>
    <p>Mat khau</p>
    <input type="text" name="password" placeholder="password"/><br>
    <input type="submit" value="login"/>
</form>
</body>
</html>
