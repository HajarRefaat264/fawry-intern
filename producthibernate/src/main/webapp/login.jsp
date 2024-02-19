<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin: 20px;
        }

        .login-form {
            width: 300px;
            margin: 0 auto;
        }

        .login-input {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
        }
        .logo {
                    width: 200px;
                    height: 200px;
                    margin-bottom: 20px;
                }

        .login-button {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<h2>Login</h2>
</br></br>
<img src="images/pro.jpg" alt="Logo" class="logo">
</br></br></br>

<div class="login-form">
    <form action="login" method="post">
        <input type="text" name="username" placeholder="Username" class="login-input" required><br>
        <input type="password" name="password" placeholder="Password" class="login-input" required><br>
        <input type="submit" value="Login" class="login-button">
    </form>
</div>

</body>
</html>
