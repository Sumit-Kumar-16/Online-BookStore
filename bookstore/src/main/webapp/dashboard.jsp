<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
<div align="center">
  <h1>Welcome to Your Dashboard</h1>
    <p>Hello, <%= session.getAttribute("username") %>!</p>
   
    <br>
    <a href="add-book.jsp">Add Cart.</a>
    <br><br>
     <a href="logout.jsp">Logout</a>
     <br><br>
     <a href="view-cart.jsp">Show Cart</a><br>
     </div>
</body>
</html>