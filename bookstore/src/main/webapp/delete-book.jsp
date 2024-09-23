<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Book</title>
</head>
<body>
<div align="center">
    <h1>Delete Book</h1>
    <form action="DeleteBookServlet" method="post">
        <label for="bookId">Book ID:</label>
        <input type="text" id="bookId" name="bookId" required><br><br>
        <input type="submit" value="Delete Book">
    </form>
    </div>
</body>
</html>