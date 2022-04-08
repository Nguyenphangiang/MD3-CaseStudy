<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/7/2022
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
            <p>Email:</p>
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
                <p><a href="/RegistrationCollab?action=create">Đăng ký</a> nếu bạn chưa có tài khoản</p>
            </div>
        </form>
    </div>
</center>
</body>
</html>
