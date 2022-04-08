<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 4/7/2022
  Time: 7:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restaurant</title>
</head>
<body>
<h1>Create Tag</h1>
<form method="post">
    <table>
        <caption><h2>Create Tag</h2></caption>
        <tr>
            <th>Tag Name</th>
            <td>
                <input type="text" name="tagName" placeholder="enter tag name">
            </td>
        </tr>
        <tr>
            <td>
                <button type="submit">Create</button>
                <button type="button" onclick="location.href='/restaurant?action=restaurant'">Back</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
