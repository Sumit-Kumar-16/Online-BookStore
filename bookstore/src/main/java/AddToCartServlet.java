

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String bookId = request.getParameter("bookId");

	        // Add book to the cart
	        HttpSession session = request.getSession();
	        List<String> cart = (List<String>) session.getAttribute("cart");
	        if (cart == null) {
	            cart = new ArrayList<>();
	        }
	        cart.add(bookId);
	        session.setAttribute("cart", cart);

	        response.sendRedirect("view-cart.jsp");
	    }
	}