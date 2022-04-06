<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nghes
  Date: 4/5/2022
  Time: 9:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="post">

    <input type="text" name="name">
    <input type="text" name="image">
    <input type="text" name="description">
    <input type="text" name="price">
    <select name="restaurant" id="">
        <c:forEach items="${restaurant}" var="r">
            <option value="${r.getId()}">${r.restaurantName}</option>
        </c:forEach>
    </select>
    <input type="submit" value="them" >
</form>
</body>
</html>
