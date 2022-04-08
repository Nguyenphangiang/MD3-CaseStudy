<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nghes
  Date: 4/7/2022
  Time: 10:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <table border="1" cellpadding="5">
        <caption>
            <h2>List of Restaurant</h2> <br>
            <h3><button  type="button" onclick="location.href = '/restaurantHome?action=createRestaurant'">Create new restaurant</button></h3>
        </caption>

        <tr>
            <th>Restaurant name</th>
            <th>Address</th>
            <th>Tel</th>
            <th>Open time</th>
            <th>Close time</th>
            <th></th>
        </tr>
        <c:forEach var="r" items="${restaurantList}">
            <tr>

                <td><c:out value="${r.getRestaurantName()}"/></td>
                <td><c:out value="${r.getRestaurantAddress()}"/></td>
                <td><c:out value="${r.getRestaurantPhone()}"/></td>
                <td><c:out value="${r.getOpenTime()}"/></td>
                <td><c:out value="${r.getCloseTime()}"/></td>
                <td>
                    <a href="/restaurantHome?action=editRestaurant&id=${r.id}">Edit</a>
                    <a href="/restaurantHome?action=deleteRestaurant&id=${r.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>

    </table>
    <br>
    <button  type="button" onclick="location.href = 'restaurantHome?action=restaurant'">Back to list of deal</button>
</div>
<div align="center">
    <table border="1" cellpadding="5">
        <caption>
            <h2>List of Deal</h2> <br>
            <button  type="button" onclick="location.href = '/restaurantHome?action=create'">Create new deal</button>
            <button  type="button" onclick="location.href = '/restaurantHome?action=listRestaurant'">List of restaurant</button>
            <button  type="button" onclick="location.href = '/restaurantHome?action=createRestaurant'">Create new restaurant</button>
        </caption>

        <tr>
            <th>Deal name</th>
            <th>image</th>
            <th>description</th>
            <th>price</th>
            <th>restaurant</th>
            <th></th>
        </tr>
        <c:forEach var="s" items="${deal}">
            <tr>
                <td><c:out value="${s.dealName}"/></td>
                <td><img src="${s.getDealImage()}" alt="image"></td>
                <td><c:out value="${s.getDescription()}"/></td>
                <td><c:out value="${s.getDealPrice()}"/></td>
                <td><c:out value="${s.getRestaurant().getRestaurantName()}"/></td>
                <td>
                    <a href="/restaurantHome?action=edit&id=${s.id}">Edit</a>
                    <a href="/restaurantHome?action=delete&id=${s.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div >
<div align="center">
    <h1>Danh sach mon an</h1>
    <button  type="button" onclick="location.href = '/restaurant?action=create'">Add New Dish</button>
    <button  type="button" onclick="location.href = '/restaurantHome?action=creat'">Go To Deal Menu</button>
<%--    <a href="/restaurant?action=create">Add New Dish</a>--%>
<%--    <a href="/restaurantHome?action=creat">Go To Deal Menu</a>--%>
    <table border="1px solid">
        <tr>
            <th>Name</th>
            <th>Note</th>
            <th>Price</th>
            <th>Restaurant Name</th>
            <th>Danh mục Tag</th>
            <th>Image</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${dishes}" var="d">
            <tr>
                <td>${d.getDishName()}</td>
                <td>${d.getDishNote()}</td>
                <td>${d.getDishPrice()}</td>
                <td>${d.getRestaurant().getRestaurantName()}</td>
                <td>
                    <c:forEach items="${d.getTag()}" var="tag">
                        <span>${tag.getTagName()}</span> &nbsp;
                    </c:forEach>
                </td>
                <td><img src="${d.dishImage}" alt="image" width="150" height="150"></td>
                <td>

                    <a href="/restaurant?action=editDish&id=${d.id}">Edit Dish</a>
                    <a href="/restaurant?action=deleteDish&id=${d.id}">Delete</a>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>

<button  type="button" onclick="location.href = '/logout'">Logout</button>

</body>
</html>
