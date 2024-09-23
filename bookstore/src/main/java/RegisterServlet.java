

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        String email = request.getParameter("email");

	        // Input validation
	        if (username == null || username.isEmpty() || password == null || password.isEmpty() || email == null || email.isEmpty()) {
	            response.sendRedirect("register.jsp?error=invalid_input");
	            return;
	        }

	        // Database connectivity and registration logic
	        try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "devil")) {
	            String query = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
	            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
	                pstmt.setString(1, username);
	                pstmt.setString(2, password);
	                pstmt.setString(3, email);
	                pstmt.executeUpdate();
	            }
	        } catch (SQLException e) {
	            response.sendRedirect("register.jsp?error=db_error");
	            return;
	        }

	        response.sendRedirect("login.jsp");
	    }
	
	}


