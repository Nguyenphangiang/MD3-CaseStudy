<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 4/7/2022
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restaurant</title>
</head>
<body>
<h1>Delete Dish</h1>
<form method="post">
    <table>
        <caption><h2>Are You Sure ?</h2></caption>
        <c:if test="${dish != null}">
            <input type="hidden" name="id" value="<c:out value='${dish.getId()}' />"/>
        </c:if>
        <tr>
            <th>Dish Name:</th>
            <td>${dish.getDishName()}</td>
        </tr>
        <tr>
            <th>Dish Image:</th>
            <td><img src="${dish.getDishImage()}" alt="image" height="150" width="150"></td>
        </tr>
        <tr>
            <th>Dish Note</th>
            <td>
                <textarea name="note"  cols="45" rows="10">${dish.getDishNote()}</textarea>
            </td>
        </tr>
        <tr>
            <th>Dish Price</th>
            <td>${dish.getDishPrice()}</td>
        </tr>
            <th>Tag </th>
            <c:forEach items="${dish.getTag()}" var="tag">
                <td><c:out value="${tag.getTagName()}"/></td>
            </c:forEach>
        <tr>
            <th>Restaurant</th>
            <td>${dish.getRestaurant().getRestaurantName()}</td>
        </tr>
        <tr>
            <td><button type="submit">Delete</button>
                <button type="button " onclick="location.href='/restaurant?action=restaurant'">Back</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
