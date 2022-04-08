<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/7/2022
  Time: 10:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration Collab</title>
</head>
<body>
<center>
    <h1>Collaborators</h1>
    <h2>
        <a href="/RegistrationCollab">List All Collaborators</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Registration New Collaborators</h2>
            </caption>
            <tr>
                <th>Collab Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Collab Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Collab Password:</th>
                <td>
                    <div class="input-box">
                        <i ></i>
                        <input type="password" placeholder="Nhập mật khẩu" name="password" size="45">
                    </div>
                </td>
            </tr>
             <tr>
            <th>Confirm Password:</th>
            <td>
                <div class="input-box">
                    <i ></i>
                <input type="password" name="confirmPassword"  size="45"/>
                </div>
            </td>
        </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit">Create</button>
                    <button type="button" onclick="location.href='/restaurantCustomer'">Back to home</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
