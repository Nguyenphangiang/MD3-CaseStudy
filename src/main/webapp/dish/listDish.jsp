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
<style>
    .pagination{
        display: inline-block;
    }
    .pagination a{
        color: black;
        font-size: 22px;
        float: left;
        padding: 8px 16px;
        text-decoration: none;
    }
    .pagination a.active{
        background-color: green;
        color: black;
    }
    .pagination a:hover:not(.active){
        background-color: darkorange;
    }
</style>
<body>
<h1>Danh sach mon an</h1>
<a href="/restaurant?action=create">Add New Dish</a>
<a href="/restaurantHome?action=creat">Go To Deal Menu</a>
<a href="/restaurant?action=createTag">Create New Tag</a>
<c:set var="page" value="${requestScope.page}"/>
<div class="pagination">
    <c:forEach begin="${1}" end="${requestScope.numPage}" var="p">
        <a class="${p==page?"active":""}" href="/restaurant?page=${p}">${p}</a>
    </c:forEach>
</div>
<table border="1px solid">
    <tr>
        <th>Name</th>
        <th>Note</th>
        <th>Price</th>
        <th>Restaurant Name</th>
        <th>Danh mục Tag</th>
        <th>Image</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${dishes}" var="d">
        <tr>
            <td>${d.getDishName()}</td>
            <td>${d.getDishNote()}</td>
            <td>${d.getDishPrice()}</td>
            <td>${d.getRestaurant().getRestaurantName()}</td>
            <td>
                <c:forEach items="${d.getTag()}" var="tag">
                    <span>${tag.getTagName()}</span> &nbsp;
                </c:forEach>
            </td>
            <td><img src="${d.dishImage}" alt="image" width="150" height="150"></td>
            <td>
                <a href="/restaurant?action=editDish&id=${d.id}">Edit Dish</a>
                <a href="/restaurant?action=deleteDish&id=${d.id}">Delete</a>
            </td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
