<%--
  Created by IntelliJ IDEA.
  User: nghes
  Date: 4/6/2022
  Time: 4:10 PM
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
                    Create new restaurant
                </h2>
            </caption>
            <tr>
                <th>Restaurant Name:</th>
                <td>
                    <input type="text" name="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Tel:</th>
                <td>
                    <input type="text" name="phone" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Open Time:</th>
                <td>
                    <input placeholder="hh:mm:ss" type="text" name="openTime" size="15"/>
                    <p>vui lòng nhập đúng định dạng hh:mm:ss</p>
                </td>

            </tr>
            <tr>
                <th>Close Time:</th>
                <td>
                    <input placeholder="hh:mm:ss" type="text" name="closeTime" size="15"/>
                    <p>vui lòng nhập đúng định dạng hh:mm:ss</p>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit" >Create</button>
                    <button  type="button" onclick="location.href = 'restaurantHome?action=restaurant'">Back to list of deal</button>
                    <button  type="button" onclick="location.href = '/restaurantHome?action=listRestaurant'">Back to list of restaurant</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
