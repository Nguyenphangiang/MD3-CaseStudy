<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 4/8/2022
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restaurant</title>
</head>
<body>
<h1>Edit Quantity</h1>
<form method="post">
  <table>
    <caption><h2>
      Edit Quantity
    </h2>
    </caption>
    <c:if test="${cart != null}">
      <input type="hidden" name="id" value="<c:out value='${cart.getId()}'/>">
    </c:if>
    <tr>
      <th>Dish Name</th>
      <td><c:out value='${cart.getDish().getDishName()}' /></td>
    </tr>
    <tr>
      <th>Dish Image</th>
      <td><img src="<c:out value='${cart.getDish().getDishImage()}' />" alt="img" width="150" height="150"></td>
    </tr>
    <tr>
      <th>Quantity</th>
      <td><input type="text" name="quantity"></td>
    </tr>
    <tr>
      <td>
        <input type="submit" value="Edit">
      </td>
    </tr>
  </table>
</form>
</body>
</html>
