package codes;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnection db = new DBConnection();
		User u = db.findUser(request.getParameter("un"), request.getParameter("pw"));
		
		if(u.getUsername() != null) {
			request.setAttribute("user", u);
			if(u.getUserType().equals("User")) {
				RequestDispatcher rd = request.getRequestDispatcher("welcomeuser.jsp");
				rd.forward(request, response);
			}
			else if(u.getUserType().equals("Admin")) {
				request.setAttribute("users", db.getUsers());
				RequestDispatcher rd = request.getRequestDispatcher("welcomeadmin.jsp");
				rd.forward(request, response);
			}
		}
		else {
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<h1>Login Failed: Try again</h1>");
			out.println("/<body></html>");
		}
		
	}

}
