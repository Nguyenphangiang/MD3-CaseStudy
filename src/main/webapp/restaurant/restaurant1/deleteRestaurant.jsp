<%--
  Created by IntelliJ IDEA.
  User: nghes
  Date: 4/6/2022
  Time: 7:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">

    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Restaurant information</legend>
        <table>
            <tr>
                <td>Restaurant name: </td>
                <td>${restaurant.getRestaurantName()}</td>
            </tr>
            <tr>
                <td>Address: </td>
                <td>${restaurant.getRestaurantAddress()}</td>
            </tr>
            <tr>
                <td>Tel: </td>
                <td>${restaurant.getRestaurantPhone()}</td>
            </tr>
            <tr>
                <td>open time: </td>
                <td>${restaurant.getOpenTime()}</td>
            </tr>
            <tr>
                <td>Close time: </td>
                <td>${restaurant.getCloseTime()}</td>
            </tr>
            <tr>
                <td><button  type="button" onclick="location.href = 'restaurantHome?action=listRestaurant'">Back to list of restaurant</button></td>
                <td><input type="submit" value="delete"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
