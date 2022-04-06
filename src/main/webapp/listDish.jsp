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
<table border="1px solid">
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Image</th>
        <th>Note</th>
        <th>Price</th>
<%--        <th>Discount Price</th>--%>
        <th>Danh mục Tag</th>
<%--        <th>Restaurant Name</th>--%>
    </tr>
    <c:forEach items="${dishes}" var="d">
        <tr>
            <td>${d.id}</td>
            <td>${d.name}</td>
            <td>${d.image}</td>
            <td>${d.note}</td>
            <td>${d.price}</td>
<%--            <td>${d.restaurant.getrestaurantName}</td>--%>
            <td>
                <c:forEach items="${d.tags}" var="tag">
                    <span>${tag.name}</span> &nbsp;
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
