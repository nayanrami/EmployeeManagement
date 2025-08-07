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

/**
 * Servlet implementation class SignupController
 * 
 * Handles user signup functionality by capturing form data,
 * creating a new Employee object, saving it via DAO layer,
 * and forwarding the response to appropriate view (JSP).
 * 
 * Mapped to URL: /SignupController
 * 
 * This controller is part of the MVC architecture and acts as a 
 * mediator between the View (signup.jsp) and Model (Employee, DAO).
 * 
 * @author Prof. Nayan Mali
 * @version 1.0
 * @since 2025-08-01
 */
@WebServlet("/SignupController")
public class SignupController extends HttpServlet {
    
    /**
     * Processes HTTP request (GET/POST) for employee registration.
     * 
     * @param request  HttpServletRequest object that contains the request the client made
     * @param response HttpServletResponse object that contains the response the servlet returns
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // Retrieve form data from request parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password"); // currently unused (you may consider saving or hashing)
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String mobileno = request.getParameter("mobileno");
        String designation = request.getParameter("designation");
        String gender = request.getParameter("gender");

        // Populate Employee model with retrieved data
        Employee employee = new Employee();
        employee.setUsername(username);
        employee.setFirstname(firstname);
        employee.setLastname(lastname);
        employee.setDesignation(designation);
        employee.setEmail(email);
        employee.setGender(gender);
        employee.setMobileno(mobileno);
        employee.setPassword(password);

        // Instantiate DAO implementation to interact with database
        EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();

        // Define dispatcher for redirecting to appropriate view
        RequestDispatcher rd;

        // Save employee to database and forward to appropriate JSP
        if (employeeDAOImpl.save(employee)) {
            rd = request.getRequestDispatcher("index.jsp");
            request.setAttribute("SUCCESS", "Employee Created..");
        } else {
            rd = request.getRequestDispatcher("signup.jsp");
            request.setAttribute("ERROR", "Error Pls Resolve");
        }

        // Forward the request and response
        rd.forward(request, response);
    }
}
