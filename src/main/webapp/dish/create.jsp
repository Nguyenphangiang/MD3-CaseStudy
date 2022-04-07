<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 4/6/2022
  Time: 11:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restaurant</title>
</head>
<body>
<h1>Add New Dish</h1>
<form method="post">
    <table>
        <tr>
            <th>Enter Dish Name</th>
            <td><input type="text" name="dishName" placeholder="enter dish name"/></td>
        </tr>
        <tr>
            <th>Enter Dish Image URL</th>
            <td><input type="text" name="dishImage" placeholder="enter url"/></td>
        </tr>
        <tr>
            <th>Enter Description</th>
            <td><textarea name="dishNote" placeholder="enter description"></textarea></td>
        </tr>
        <tr>
            <th>Enter Dish Price</th>
            <td><input type="text" name="dishPrice" placeholder="enter price"></td>
        </tr>
        <tr>
            <th>Choose Tag</th>
            <td>
                <select name="tags" id="tags" multiple>
                    <c:forEach items="${tagList}" var="tag">
                        <option value="${tag.id}">${tag.tagName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th>Choose Restaurant</th>
            <td>
                <select name="restaurant" id="restaurant">
                    <c:forEach items="${restaurantList}" var="res">
                        <option value="${res.id}">${res.restaurantName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td><button type="button" onclick="location.href='/restaurant?action=restaurant'">Back</button></td>
            <td><button type="submit" onclick="location.href='/restaurant?action=restaurant'">Add</button></td>
        </tr>
    </table>
</form>
</body>
</html>
