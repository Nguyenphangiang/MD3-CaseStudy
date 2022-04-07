<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nghes
  Date: 4/6/2022
  Time: 9:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h3><c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if></h3>
    <button  type="button" onclick="location.href = 'restaurantHome?action=restaurant'">Back to list of deal</button>
    <button  type="button" onclick="location.href = 'restaurantHome?action=listRestaurant'">Back to list of restaurant</button>
</div>
</body>
</html>
