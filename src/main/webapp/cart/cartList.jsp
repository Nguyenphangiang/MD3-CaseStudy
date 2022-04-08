<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 4/8/2022
  Time: 8:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restaurant</title>
</head>
<body>
<form method="post" >
    <table border="1px solid black">
        <caption><h2>Customer Buy List</h2></caption>
        <tr>
            <th>Dish Name</th>
            <th>Dish Note</th>
            <th>Dish Price</th>
            <th>Restaurant</th>
            <th>Quantity</th>
            <th>Tags</th>
            <th>Dish Image</th>
            <th></th>
        </tr>
        <c:forEach items="${carts}" var="cart">
            <tr>
                <td>${cart.getDish().getDishName()}</td>
                <td>${cart.getDish().getDishNote()}</td>
                <td>${cart.getDish().getDishPrice()}</td>
                <td>${cart.getDish().getRestaurant().getRestaurantName()}</td>
                <td>${cart.getQuantity()}</td>
                <td>
                    <c:forEach items="${cart.getDish().getTag()}" var="tags">
                        ${tags.getTagName()}
                    </c:forEach>
                </td>
                <td><img src="${cart.getDish().getDishImage()}" alt="img" width="150" height="150">
                        </td>
                <td>
                <button type="submit"><a href="/restaurantCustomer?action=editCart&id=${cart.getId()}">Edit</a></button>
                    <button type="submit"><a href="/restaurantCustomer?action=deleteCart&id=${cart.getId()}">Delete</a></button>
                </td>
            </tr>
        </c:forEach>
            <tr>
                <th>Total:</th>
                <td>${total.getTotal()}</td>
            </tr>
    </table>
</form>
<button type="button"><a href="/restaurantCustomer?action=showFormBuy">Pay</a></button>
<button type="button" onclick="location.href='/restaurantCustomer?action=restaurant'">Back</button>
</body>
</html>
