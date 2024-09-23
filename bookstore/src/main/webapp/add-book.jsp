<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
</head>
<body>
 <h1>Add Book</h1>
    <form action="AddBookServlet" method="post">
        Title: <input type="text" name="title"><br><br>
        Author: <input type="text" name="author"><br><br>
        Price: <input type="text" name="price"><br><br>
        Quantity: <input type="text" name="quantity"><br><br>
        <input type="submit" value="Add Book">
    </form>
</body>
</html>