<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Book</title>
</head>
<body>
<div align="center">
   <h1>Edit Book</h1>
    <form action="EditBookServlet" method="post">
        <label for="bookId">Book ID:</label><br>
        <input type="text" id="bookId" name="bookId" value="${book.id}" readonly><br>
        
        <label for="title">Title:</label><br>
        <input type="text" id="title" name="title" value="${book.title}" required><br>
        
        <label for="author">Author:</label><br>
        <input type="text" id="author" name="author" value="${book.author}" required><br>
        
        <label for="price">Price:</label><br>
        <input type="text" id="price" name="price" value="${book.price}" required><br>
        
        <button type="submit">Save Changes</button>
    </form>
    </div>
</body>
</html>