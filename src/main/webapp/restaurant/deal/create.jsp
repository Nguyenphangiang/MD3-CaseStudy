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
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Create new deal
                </h2>
            </caption>
            <tr>
                <th>Deal Name:</th>
                <td>
                    <input type="text" name="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Image:</th>
                <td>
                    <input type="text" name="image" />
                </td>
            </tr>
            <tr>
                <th>Description:</th>
                <td>
                    <textarea name="description" cols="45"  rows="10"></textarea>
                </td>
            </tr>
            <tr>
                <th>Price:</th>
                <td>
                    <input type="text" name="price" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Restaurant Name:</th>
                <td>
<%--                    <select name="restaurant">--%>
<%--                        <c:forEach items="${restaurant}" var="r">--%>
<%--                            <option value="${r.getId()}">${r.restaurantName}</option>--%>
<%--                        </c:forEach>--%>
<%--                    </select>--%>
                    <select name="restaurant" id="">
                        <c:forEach items="${restaurant}" var="r">
                            <option value="${r.getId()}">${r.restaurantName}</option>
                        </c:forEach>
                    </select>

                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit" >Create</button>
                    <button  type="button" onclick="location.href = 'restaurantHome?action=restaurant'">Back to list of deal</button>
                </td>
            </tr>
        </table>
    </form>
    <p>Nếu không có nhà hàng bạn muốn chọn trong danh sách bạn có thể <a href="/restaurantHome?action=createRestaurant">thêm nhà hàng mới</a></p>
</div>

</body>
</html>
