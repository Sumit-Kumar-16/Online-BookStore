import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("bookId");

        // Assuming you have a BookDao class to delete the book
        BookDao bookDao = new BookDao();
        boolean deleted = bookDao.deleteBook(bookId);

        if (deleted) {
            response.getWriter().println("Book deleted successfully.");
        } else {
            response.getWriter().println("Failed to delete book.");
        }
    }
}
