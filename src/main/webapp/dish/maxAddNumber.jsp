<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 07/04/2022
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>3 Max Add Number</title>
</head>
<body>
<h1>3 Max Add Number </h1>
<form method="post">
    <table border="1px solid">
    <tr>
        <th>Tag name</th>
        <th>Tag add number</th>
    </tr>
    <c:forEach items="${tags}" var="t"  >
        <tr>
            <td>${t.getTagName()}</td>
            <td>${t.getAddNumber()}</td>
        </tr>

    </c:forEach>
    </table>

</form>

</body>
</html>
