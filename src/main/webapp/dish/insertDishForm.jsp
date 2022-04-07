<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 06/04/2022
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<H1>Add Menu</H1>
<a href="restaurant?action=default">Back to list menu</a>
<form method="post">
    <input type="text" name="name" placeholder="Dish name">
    <input type="text" name="image" placeholder="Dish image">
    <textarea name="note" cols="45"  rows="10" placeholder="note"></textarea>
    <input type="text" name="price" placeholder="Price">
    <select name="tags" id="tags" multiple>
        <c:forEach items="${tags}" var="tag">
            <option value="${tag.getId()}">${tag.getTagName()}</option>
        </c:forEach>
    </select>
    <select name="restaurant" id="restaurant" >
        <c:forEach items="${restaurants}" var="restaurant">
            <option value="${restaurant.getId()}">${restaurant.getRestaurantName()}</option>
        </c:forEach>
    </select>

    <input value="Add" type="submit">
</form>

</body>
</html>

