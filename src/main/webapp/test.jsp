[08/04/2022 14:51:23] Pan Yan: [Hình ảnh]
[08/04/2022 14:51:58] Trung Đức: <%--
  Created by IntelliJ IDEA.
  User: lequan
  Date: 4/6/22
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Librarian Form</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="account">Li-bra-ry</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="/account" class="active">Home</a></li>
                <li><a href="account?action=admin" class="active">Admin</a></li>
                <li><a href="account?action=librarian">Librarian</a></li>
                <li><a href="account?action=user">User</a></li>
            </ul>

        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<div class='container'>
    <h3>User Login</h3>
    ${messageloginuser}
    <form action="account?action=user" method="post" style="width:300px">
        <div class="form-group">
            <label for="email1">Email address</label>
            <input type="email" class="form-control" id="email1" name="email" placeholder="Email"/>
        </div>
        <div class="form-group">
            <label for="password1">Password</label>
            <input type="password" class="form-control" id="password1" name="password" placeholder="Password"/>
        </div>
        <button type="submit" class="btn btn-primary">Login</button>
    </form>
    <h4>Chưa có tài khoản à  bạn tôi. Làm cái thôi chứ nhờ</h4>
    <a href="/account?action=adduser"
       class="btn btn-danger">Đăng ký</a>
</div>
</body>
</html>
