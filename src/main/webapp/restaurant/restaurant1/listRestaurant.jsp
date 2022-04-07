<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nghes
  Date: 4/6/2022
  Time: 7:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <table border="1" cellpadding="5">
        <caption>
            <h2>List of Restaurant</h2> <br>
            <h3><button  type="button" onclick="location.href = '/restaurantHome?action=createRestaurant'">Create new restaurant</button></h3>
        </caption>

        <tr>
            <th>Restaurant name</th>
            <th>Address</th>
            <th>Tel</th>
            <th>Open time</th>
            <th>Close time</th>
            <th></th>
        </tr>
        <c:forEach var="r" items="${restaurantList}">
            <tr>

                <td><c:out value="${r.getRestaurantName()}"/></td>
                <td><c:out value="${r.getRestaurantAddress()}"/></td>
                <td><c:out value="${r.getRestaurantPhone()}"/></td>
                <td><c:out value="${r.getOpenTime()}"/></td>
                <td><c:out value="${r.getCloseTime()}"/></td>
                <td>
                    <a href="/restaurantHome?action=editRestaurant&id=${r.id}">Edit</a>
                    <a href="/restaurantHome?action=deleteRestaurant&id=${r.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>

    </table>
    <br>
    <button  type="button" onclick="location.href = 'restaurantHome?action=restaurant'">Back to list of deal</button>
</div>
</body>
</html>
