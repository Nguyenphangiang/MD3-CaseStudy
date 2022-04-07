<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nghes
  Date: 4/6/2022
  Time: 9:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    Edit restaurant
                </h2>
            </caption>
            <c:if test="${restaurant != null}">
                <input type="hidden" name="id" value="<c:out value='${restaurant.getId()}' />"/>
            </c:if>
            <tr>
                <th>Restaurant Name: </th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${restaurant.getRestaurantName()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Address: </th>
                <td>
                    <input type="text" name="address" size="45"
                           value="<c:out value='${restaurant.getRestaurantAddress()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Tel:</th>
                <td>
                    <input type="text" name="phone" size="45"
                           value="<c:out value='${restaurant.getRestaurantPhone()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Open time:</th>
                <td>
                    <input type="text" name="openTime" size="15"
                           value="<c:out value='${restaurant.getOpenTime()}' />"
                    />
                </td>
            </tr>
            <tr>
            <th>Close time:</th>
            <td>
                <input type="text" name="closeTime" size="15"
                       value="<c:out value='${restaurant.getCloseTime()}' />"
                />
            </td>
        </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit" >Save</button>
                    <button  type="button" onclick="location.href = 'restaurantHome?action=restaurant'">Back to list of deal</button>
                    <button  type="button" onclick="location.href = 'restaurantHome?action=listRestaurant'">Back to list of restaurant</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
