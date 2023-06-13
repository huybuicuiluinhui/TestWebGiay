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
<style>
    /* Existing styles */

    /* Additional styles for registration form */
    .register-container {
        max-width: 400px;
        margin: 0 auto;
        padding: 40px;
        background-color: #fff;
        border-radius: 5px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }
</style>

<body>
<!-- Existing login form code -->

<div class="register-container">
    <div class="login-title">Register</div>
    <form action="/register" method="post">
        <div class="form-group">
            <label for="username" class="form-label">Username</label>
            <input type="text" id="username" name="username" class="form-control" placeholder="Username" required>
        </div>
        <div class="form-group">
            <label for="password" class="form-label">Password</label>
            <input type="password" id="password" name="pass" class="form-control" placeholder="Password" required>
        </div>
        <div class="form-group">
            <label for="email" class="form-label">Email</label>
            <input type="email" id="email" name="email" class="form-control" placeholder="Your Email" required>
        </div>
        <button type="submit" class="btn-login">Register</button>
        <div class="login-links">
            <a href="/login">Login</a>
        </div>
        <div class="login-links">
            <a href="#">Already have an account?</a>
        </div>
    </form>
</div>

</body>
</html>