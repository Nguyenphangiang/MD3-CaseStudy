<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/7/2022
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Collab
                </h2>
            </caption>
            <c:if test="${collab1 != null}">
                <input type="hidden" name="id" value="<c:out value='${collab1.getId()}' />"/>
            </c:if>
            <tr>
                <th>Collab Name: </th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${collab1.collabName}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Collab Email: </th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${collab1.collabEmail}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Collab Password:</th>
                <td>
                    <input type="text" name="password" size="45"
                           value="<c:out value='${collab1.collabPassword}' />"
                    />
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <button type="submit" >Save</button>
<%--                    <button  type="button" onclick="location.href = 'restaurant?action=restaurant'">Back to list of deal</button>--%>
<%--                    <button  type="button" onclick="location.href = 'restaurant?action=listRestaurant'">Back to list of restaurant</button>--%>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
