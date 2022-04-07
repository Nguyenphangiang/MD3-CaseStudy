<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/7/2022
  Time: 11:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h1><c:if test='${requestScope["messageSuccess"] != null}'>
        <span class="messageSuccess">${requestScope["messageSuccess"]}</span>
    </c:if></h1>
    <a href="RegistrationCollab"><input type="submit" value="Back to list"/></a>
</div>
</body>
</html>
