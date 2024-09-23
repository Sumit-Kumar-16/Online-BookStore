<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Cart</title>
</head>
<body>
<div align="center">
   <h1>Shopping Cart</h1>
    <table border="1">
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
        </tr>
        <c:forEach var="item" items="${cart.items}">
            <tr>
                <td>${item.book.title}</td>
                <td>${item.book.author}</td>
                <td>${item.book.price}</td>
                <td>${item.quantity}</td>
                <td>${item.quantity * item.book.price}</td>
            </tr>
        </c:forEach>
    </table>
    <p>Total Price: ${cart.totalPrice}</p>
    <form action="CheckoutServlet" method="post">
        <button type="submit">Checkout</button>
    </form>
    <a href="dashboard.jsp">Continue Shopping</a>
    </div>
</body>
</html>