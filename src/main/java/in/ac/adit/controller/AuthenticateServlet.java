package in.ac.adit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ac.adit.erp.dao.EmployeeDAOImpl;
import in.ac.adit.erp.model.Employee;

/**
 * The {@code AuthenticateServlet} class handles user authentication requests.
 * <p>
 * This servlet is mapped to the URL pattern {@code /AuthenticateServlet} using
 * the {@code @WebServlet} annotation. Typically, it processes login credentials
 * submitted via an HTTP POST or GET request and validates them against stored
 * user data (e.g., database or config).
 * </p>
 *
 * <p>
 * <b>Note:</b> Currently, the {@code service()} method is empty and should be
 * implemented to handle login functionality.
 * </p>
 *
 * @author Prof. Nayan Mali
 * @version 1.0
 * @since 2025-08-01
 */
@WebServlet("/AuthenticateServlet")
public class AuthenticateServlet extends HttpServlet {

	/**
	 * Handles both GET and POST requests for user authentication.
	 * <p>
	 * Override this method to add logic for extracting login credentials from the
	 * {@code HttpServletRequest}, validating them, managing session state, and
	 * redirecting the user based on authentication status.
	 * </p>
	 *
	 * @param request  the {@code HttpServletRequest} object containing client
	 *                 request data
	 * @param response the {@code HttpServletResponse} object used to return
	 *                 response to client
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: Implement authentication logic here

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();

		RequestDispatcher rd;

		if (employeeDAOImpl.isAuthenticated(username, password)) {
			Cookie cookie = new Cookie("AUTHUSER", username);
			response.addCookie(cookie);
			rd = request.getRequestDispatcher("home.jsp");
		} else {
			request.setAttribute("ERROR", "Invalid Username / Password");
			rd = request.getRequestDispatcher("index.jsp");
		}
		rd.forward(request, response);
	}
}
