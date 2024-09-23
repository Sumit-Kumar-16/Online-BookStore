import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.sumit.Book;

@WebServlet("/RemoveFromCartServlet")
public class RemoveFromCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("bookId");

        // Assuming you have a BookDao class to fetch book details
        BookDao bookDao = new BookDao();
        Book book = bookDao.getBookById(bookId);

        if (book != null) {
            HttpSession session = request.getSession();
            List<String> cart = (List<String>) session.getAttribute("cart");
            if (cart != null) {
                cart.remove(bookId);
            }
            session.setAttribute("cart", cart);
            response.sendRedirect("viewCart.jsp");
        } else {
            response.getWriter().println("Book not found.");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
