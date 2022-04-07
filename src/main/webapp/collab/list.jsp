<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/7/2022
  Time: 10:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>Collab Manegment</h1>
    <h2>
        <a href="/RegistrationCollab?action=create">Regist Collaborators</a><br/></h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Collab</h2></caption>
        <tr>
<%--            <th>ID</th>--%>
            <th>Name</th>
            <th>Email</th>
            <th>Password</th>
        </tr>
        <c:forEach var="collab" items="${collabList}">
            <tr>
<%--                <td><c:out value="${collab.id}"/></td>--%>
                <td><c:out value="${collab.collabName}"/></td>
                <td><c:out value="${collab.collabEmail}"/></td>
                <td><c:out value="${collab.getCollabPassword()}"/></td>
                <td>
                    <a href="/RegistrationCollab?action=edit&id=${collab.getId()}">Edit</a>
                    <a href="/RegistrationCollab?action=delete&id=${collab.getId()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
