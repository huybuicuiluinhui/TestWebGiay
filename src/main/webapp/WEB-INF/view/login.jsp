<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
        <link rel="stylesheet" href="/src/main/webapp/css/custom/style.css" />
        <link rel="stylesheet" href="../css/plugin/bootstrap.min.css" />
        <link rel="stylesheet" href="/src/main/webapp/css/custom/index.css" />
        <link rel="stylesheet" href="../assets/font-we/bootstrap-icons.css" />
        <link rel="stylesheet" href="/src/main/webapp/css/custom/stylecopy.css" />
    <link rel="stylesheet" href="../../resources/css/login.css">
</head>
<body>
<%--<form action="" method="post">--%>
        <div class="login-container">
            <div class="alert text-dark">${message}</div>
            <div class="login-title">Login</div>
            <form action="/account/login" method="post">
                <div class="form-group">
                    <label for="username" class="form-label">Username</label>
                    <input type="text" id="username" name="username" class="form-control" placeholder="Username" required>
                </div>
                <div class="form-group">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" id="password" name="pass" class="form-control" placeholder="Password" required>
                </div>
                <div class="checkbox">
                    <label><input type="checkbox" name="chkRemember"> Remember me</label>
                </div>
                <button type="submit" class="btn-login">Login</button>

            </form>
            <div class="login-links">
                <a href="/register">Register</a>
                <a href="/forgot">Forgot Password</a>
            </div>
        </div>
</body>
</html>