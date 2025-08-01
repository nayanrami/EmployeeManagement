package in.ac.adit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ac.adit.erp.dao.EmployeeDAOImpl;
import in.ac.adit.erp.model.Employee;

@WebServlet("/SignupController")
public class SignupController extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String mobileno = request.getParameter("mobileno");
		String designation = request.getParameter("designation");
		String gender = request.getParameter("gender");

		Employee employee = new Employee();
		employee.setUsername(username);
		employee.setFirstname(firstname);
		employee.setLastname(lastname);
		employee.setDesignation(designation);
		employee.setEmail(email);
		employee.setGender(gender);
		employee.setMobileno(mobileno);

		EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();

		RequestDispatcher rd;
		if (employeeDAOImpl.save(employee)) {
			rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("SUCCESS", "Employee Created..");
		} else {
			rd = request.getRequestDispatcher("signup.jsp");
			request.setAttribute("ERROR", "Error Pls Resolve");
		}
		rd.forward(request, response);
	}
}
