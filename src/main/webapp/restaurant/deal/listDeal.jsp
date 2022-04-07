<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nghes
  Date: 4/6/2022
  Time: 9:41 PM
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
            <h2>List of Deal</h2> <br>
            <button  type="button" onclick="location.href = '/restaurantHome?action=create'">Create new deal</button>
            <button  type="button" onclick="location.href = '/restaurantHome?action=listRestaurant'">List of restaurant</button>
            <button  type="button" onclick="location.href = '/restaurantHome?action=createRestaurant'">Create new restaurant</button>
        </caption>

        <tr>
            <th>ten deal</th>
            <th>hinh anh</th>
            <th>mo ta</th>
            <th>gia</th>
            <th>ten nha hang</th>
            <th></th>
        </tr>
        <c:forEach var="s" items="${deal}">
            <tr>
                <td><c:out value="${s.dealName}"/></td>
                <td><img src="${s.getDealImage()}" alt="image"></td>
                <td><c:out value="${s.getDescription()}"/></td>
                <td><c:out value="${s.getDealPrice()}"/></td>
                <td><c:out value="${s.getRestaurant().getRestaurantName()}"/></td>
                <td>
                    <a href="/restaurantHome?action=edit&id=${s.id}">Edit</a>
                    <a href="/restaurantHome?action=delete&id=${s.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
