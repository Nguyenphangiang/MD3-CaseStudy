<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nghes
  Date: 4/7/2022
  Time: 10:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <div class="login-form">
        <form action="" method="post">
            <h1>Đăng nhập vào GADC</h1><br>
            <p><c:if test='${requestScope["message"] != null}'>
                <span class="message">${requestScope["message"]}</span>
            </c:if></p>
            <p>Tài khoản:</p>
            <div class="input-box">
                <i ></i>
                <input type="text" placeholder="Nhập email" name="collabEmail">
            </div>
            <p>Mật khẩu:</p>
            <div class="input-box">
                <i ></i>
                <input type="password" placeholder="Nhập mật khẩu" name="collabPassword">
            </div>
            <br>
            <div class="btn-box">
                <button type="submit">
                    Đăng nhập
                </button>
                <p><a href="">Đăng ký</a> nếu bạn chưa có tài khoản</p>
            </div>
        </form>
    </div>
</center>
</body>
</html>
