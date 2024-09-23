import java.io.IOException;

import com.sumit.Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AdminDashboardServlet")
public class AdminDashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookDao bookDao;

    public void init() {
        bookDao = new BookDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("admin") != null) {
            // Admin is logged in, show the admin dashboard
            request.getRequestDispatcher("admin-dashboard.jsp").forward(request, response);
        } else {
            response.sendRedirect("admin-login.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "add":
                    addBook(request, response);
                    break;
                case "edit":
                    editBook(request, response);
                    break;
                case "delete":
                    deleteBook(request, response);
                    break;
                default:
                    response.sendRedirect("admin-dashboard.jsp");
                    break;
            }
        }
    }

    private void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extract book details from request parameters
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        double price = Double.parseDouble(request.getParameter("price"));

        // Create a new Book object
        Book book = new Book(null,title, author, price,0);

        // Add the book to the database
        boolean added = bookDao.addBook(book);

        // Redirect to the admin dashboard with a success or error message
        if (added) {
            response.sendRedirect("admin-dashboard.jsp?message=Book added successfully.");
        } else {
            response.sendRedirect("admin-dashboard.jsp?error=Failed to add book.");
        }
    }

    private void editBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extract book details from request parameters
        String bookId = request.getParameter("bookId");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        double price = Double.parseDouble(request.getParameter("price"));

        // Create a new Book object
        Book book = new Book(bookId, title, author, price,0);

        // Update the book in the database
        boolean updated = bookDao.updateBook(book);

        // Redirect to the admin dashboard with a success or error message
        if (updated) {
            response.sendRedirect("admin-dashboard.jsp?message=Book updated successfully.");
        } else {
            response.sendRedirect("admin-dashboard.jsp?error=Failed to update book.");
        }
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("bookId");

        // Delete the book from the database
        boolean deleted = bookDao.deleteBook(bookId);

        // Redirect to the admin dashboard with a success or error message
        if (deleted) {
            response.sendRedirect("admin-dashboard.jsp?message=Book deleted successfully.");
        } else {
            response.sendRedirect("admin-dashboard.jsp?error=Failed to delete book.");
        }
    }
}
