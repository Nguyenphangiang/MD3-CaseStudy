<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nghes
  Date: 4/6/2022
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<%--<form action="" method="post">--%>

<%--    <input type="text" name="name">--%>
<%--    <input type="text" name="image">--%>
<%--    <input type="text" name="description">--%>
<%--    <input type="text" name="price">--%>
<%--    <select name="restaurant" id="">--%>
<%--        <c:forEach items="${restaurant}" var="r">--%>
<%--            <option value="${r.getId()}">${r.restaurantName}</option>--%>
<%--        </c:forEach>--%>
<%--    </select>--%>
<%--    <input type="submit" value="them" >--%>
<%--</form>--%>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit deal
                </h2>
            </caption>
            <c:if test="${deal != null}">
                <input type="hidden" name="id" value="<c:out value='${deal.getId()}' />"/>
            </c:if>
            <tr>
                <th>Deal Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${deal.getDealName()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Image:</th>
                <td>
                    <input type="text" name="image" size="45"
                           value="<c:out value='${deal.getDealImage()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Description:</th>
                <td>
                    <textarea name="description" cols="45"  rows="10">${deal.getDescription()}</textarea>
                </td>
            </tr>
            <tr>
                <th>Price:</th>
                <td>
                    <input type="text" name="price" size="15"
                           value="<c:out value='${deal.getDealPrice()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Restaurant Name:</th>
                <td>
                        <select name="restaurant" id="">
                            <c:forEach items="${restaurant}" var="r">
                                <option value="${r.getId()}">${r.restaurantName}</option>
                            </c:forEach>
                        </select>
                </td>
            </tr>


            <tr>
<%--                <td>--%>
<%--                    <input type="submit" value="Back to list of deal">--%>
<%--                    <a href="restaurant?action=restaurant">List All Deal</a>--%>
<%--                </td>--%>
                <td colspan="2" align="center">
                    <button type="submit" >Save</button>
                    <button  type="button" onclick="location.href = 'restaurantHome?action=restaurant'">Back to list of deal</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
