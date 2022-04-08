<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 07/04/2022
  Time: 01:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Quan ly Menu</title>
</head>
<body>
<center>
    <h1>Menu Management</h1>
    <h2>
        <a href="restaurant?action=default">Back to list menu</a>
    </h2>
</center>
<div >
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Dish
                </h2>
            </caption>
            <c:if test="${dish != null}">
                <input type="hidden" name="id" value="<c:out value='${dish.getId()}' />"/>
            </c:if>
            <tr>
                <th>Dish Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${dish.getDishName()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Dish Image:</th>
                <td>
                    <input type="text" name="image" size="45"
                           value="<c:out value='${dish.getDishImage()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Dish Note:</th>
                <td>
                    <textarea name="note" cols="45" rows="10">${dish.getDishNote()}</textarea>
                </td>
            </tr>
            <tr>
                <th>Dish Price:</th>
                <td>
                    <input type="text" name="price" size="15"
                           value="<c:out value='${dish.getDishPrice()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Dish Tag:</th>
                <td>
                    <select name="tags" multiple size="20px">
                        <c:forEach items="${tagList}" var="tag">
                            <option value="${tag.id}" >${tag.tagName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Restaurant:</th>
                <td><input type="text" name="restaurant" value="${dish.getRestaurant().getRestaurantName()}" readonly/>
<%--                    ${dish.getRestaurant().getRestaurantName()}</td>--%>

<%--                   <select name="restaurant" id="restaurant">--%>
<%--                   <c:forEach items="${restaurantList}" var="res">--%>
<%--                       <option value="${res.id}">${res.restaurantName}</option>--%>
<%--                   </c:forEach>--%>
<%--                   </select>--%>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit" onclick="location.href='/restaurant?action=restaurant'">Save</button>
                    <button type="button" onclick="location.href='/restaurant?action=restaurant'">Back</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
