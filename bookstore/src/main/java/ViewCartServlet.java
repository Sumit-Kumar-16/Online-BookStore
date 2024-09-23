import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.sumit.Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ViewCartServlet")
public class ViewCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>View Cart</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Shopping Cart</h1>");

        HttpSession session = request.getSession();
        List<String> cart = (List<String>) session.getAttribute("cart");

        if (cart == null || cart.isEmpty()) {
            out.println("<p>Your cart is empty.</p>");
        } else {
            // Assuming you have a BookDao class to fetch book details
            BookDao bookDao = new BookDao();

            out.println("<table border=\"1\">");
            out.println("<tr><th>Title</th><th>Author</th><th>Price</th><th>Quantity</th><th>Action</th></tr>");
            for (String bookId : cart) {
                Book book = null;
                try {
                    book = bookDao.getBookById(bookId);
                    if (book != null) {
                        out.println("<tr>");
                        out.println("<td>" + book.getTitle() + "</td>");
                        out.println("<td>" + book.getAuthor() + "</td>");
                        out.println("<td>" + String.format("%.2f", book.getPrice()) + "</td>");
                        out.println("<td>1</td>"); // Assuming quantity is always 1 for each book
                        out.println("<td><a href='RemoveFromCartServlet?bookId=" + book.getId() + "'>Remove</a></td>");
                        out.println("</tr>");
                    } else {
                        out.println("<tr><td colspan=\"5\">Book not found for ID: " + bookId + "</td></tr>");
                    }
                } catch (Exception e) {
                    out.println("<tr><td colspan=\"5\">Error fetching book details for ID: " + bookId + "</td></tr>");
                    e.printStackTrace();
                }
            }
            out.println("</table>");
        }

        out.println("<br><a href=\"dashboard.jsp\">Continue Shopping</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
