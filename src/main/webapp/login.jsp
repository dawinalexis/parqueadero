<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        form {
            background-color: #ffffff;
            box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.1);
            max-width: 300px;
            padding: 20px;
            border-radius: 5px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            color: #ffffff;
            background-color: #007BFF;
            border: none;
		{
    </style>
</head>
<body>
    <form action="login" method="post">
        <label for="user">Usuario:</label>
        <input type="text" id="user" name="user">
        <label for="password">Contraseña:</label>
        <input type="password" id="password" name="password">
        <input type="submit" value="Iniciar sesión">
    </form>
</body>
</html>



