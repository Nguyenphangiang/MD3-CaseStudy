<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 06/04/2022
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sach mon an</h1>
<h2>
    <a href="restaurant?action=showMaxAddNumber">Max Add Number</a>
</h2>
<h2>
    <a href="restaurant?action=createDish">Add New Dish</a>
</h2>
<table border="1px solid">
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Image</th>
        <th>Note</th>
        <th>Price</th>
        <th>Restaurant Name</th>
        <th>Danh mục Tag</th>

    </tr>
    <c:forEach items="${dishes}" var="d">
        <tr>
            <td>${d.getId()}</td>
            <td>${d.getDishName()}</td>
            <td>${d.getDishImage()}</td>
            <td>${d.getDishNote()}</td>
            <td>${d.getDishPrice()}</td>
            <td>${d.getRestaurant().getRestaurantName()}</td>
            <td>
                <c:forEach items="${d.getTag()}" var="tag">
                    <span>${tag.getTagName()}</span> &nbsp;
                </c:forEach>
            </td>
            <td><a href="restaurant?action=editDish&id=${d.id}">Edit</a></td>


        </tr>
    </c:forEach>
</table>
</body>
</html>
