<style>
    body {
        background-color: #f8f9fa;
        font-family: Arial, sans-serif;
    }

    .login-container {
        max-width: 400px;
        margin: 0 auto;
        padding: 40px;
        background-color: #fff;
        border-radius: 5px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    .login-title {
        text-align: center;
        font-size: 24px;
        margin-bottom: 30px;
    }

    .form-group {
        margin-bottom: 20px;
    }

    .form-label {
        font-weight: bold;
    }

    .form-control {
        width: 100%;
        padding: 10px;
        font-size: 16px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    .btn-login {
        width: 100%;
        padding: 12px;
        font-size: 16px;
        color: #fff;
        background-color: #007bff;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    .btn-login:hover {
        background-color: #0069d9;
    }

    .login-links {
        margin-top: 20px;
        text-align: center;
    }

    .login-links a {
        text-decoration: none;
        color: #007bff;
        margin-right: 10px;
    }

</style>

<body>
<div class="login-container">
    <div class="login-title">Forgot Password</div>
    <form action="/forgot-password" method="post">
        <div class="form-group">
            <label  class="form-label">User</label>
            <input type="text"  name="userName" class="form-control"required>

            <label  class="form-label">Email</label>
            <input type="email" name="email" class="form-control"  required>

            <label  class="form-label">Password</label>
            <input type="password" name="pass" class="form-control"  required>
        </div>
        <button type="submit" class="btn-login" onclick="if(!confirm('Ban chac chan thay doi mat khau chu?')){return false;}else{return true;}">Reset Password</button>
    </form>
    <div class="login-links">
        <a href="/account/login">Back to Login</a>
        <a href="/register">Register</a>
    </div>
</div>
</body>