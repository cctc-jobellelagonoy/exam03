package codes;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SignUp() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnection db = new DBConnection();
		User u = db.insertUser(
					request.getParameter("un"),
					request.getParameter("pw"),
					request.getParameter("fn"),
					request.getParameter("ln"),
					request.getParameter("role")
				);
		request.setAttribute("user", u);
		if(request.getParameter("role").equals("Admin")) {
			request.setAttribute("users", db.getUsers());
			RequestDispatcher rd = request.getRequestDispatcher("welcomeadmin.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("welcomeuser.jsp");
			rd.forward(request, response);
		}
	}

}
