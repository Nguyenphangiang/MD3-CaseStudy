<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nghes
  Date: 4/6/2022
  Time: 9:15 AM
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
        <legend>deal information</legend>
        <table>
            <tr>
                <td>deal: </td>
                <td>${deal.getDealName()}</td>
            </tr>
            <tr>
                <td>image: </td>
                <td>${deal.getDealImage()}</td>
            </tr>
            <tr>
                <td>description: </td>
                <td>${deal.getDescription()}</td>
            </tr>
            <tr>
                <td>price: </td>
                <td>${deal.getDealPrice()}</td>
            </tr>
            <tr>
                <td>restaurant: </td>
                <td>${deal.getRestaurant().getRestaurantName()}</td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="delete"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
