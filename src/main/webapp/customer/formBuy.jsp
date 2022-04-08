<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 4/8/2022
  Time: 12:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restaurant</title>
</head>
<body>
<form >
    <table>
        <tr>
            <th>Enter Your Name:</th>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <th>Enter Your Address:</th>
            <td><input type="text" name="address"></td>
        </tr>
        <tr>
            <th>Enter Your Phone:</th>
            <td><input type="text" name="phone"></td>
        </tr>
        <tr>
            <td>
                <button type="button" onclick="location.href='/restaurantCustomer?action=confirm'">Confirm</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
