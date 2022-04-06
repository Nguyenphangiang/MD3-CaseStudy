<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 4/5/2022
  Time: 11:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <div align="center">
    <table border="1" cellpadding="5">
      <caption>
        <h2>List of Deal</h2> <br>
        <h3><button  type="button" onclick="location.href = '/restaurant?action=create'">Create new deal</button></h3>
        <h3><button  type="button" onclick="location.href = '/restaurant?action=listRestaurant'">List of restaurant</button></h3>
        <h3><button  type="button" onclick="location.href = '/restaurant?action=createRestaurant'">Create new restaurant</button></h3>
      </caption>

      <tr>
        <th>ten deal</th>
        <th>hinh anh</th>
        <th>mo ta</th>
        <th>gia</th>
        <th>ten nha hang</th>
        <th></th>
      </tr>
      <c:forEach var="s" items="${deal}">
        <tr>
          <td><c:out value="${s.dealName}"/></td>
          <td><c:out value="${s.getDealImage()}"/></td>
          <td><c:out value="${s.getDescription()}"/></td>
          <td><c:out value="${s.getDealPrice()}"/></td>
          <td><c:out value="${s.getRestaurant().getRestaurantName()}"/></td>
          <td>
            <a href="/restaurant?action=edit&id=${s.id}">Edit</a>
            <a href="/restaurant?action=delete&id=${s.id}">Delete</a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </div>
  </body>
</html>
