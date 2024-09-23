<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<div align="justify">

<h1>Register</h1>
    <form action="RegisterServlet" method="post">
        Username: <input type="text" name="username"><br><br>
        Password: <input type="password" name="password"><br><br>
         Email: <input type="email" name="email"><br><br>
        <input type="submit" value="Register">
        </div>
</body>
</html>