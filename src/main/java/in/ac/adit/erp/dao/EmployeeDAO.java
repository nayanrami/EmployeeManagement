package in.ac.adit.erp.dao;

import java.util.List;
import in.ac.adit.erp.model.Employee;

/**
 * EmployeeDAO defines the operations to be performed on the Employee data model.
 * It serves as an abstraction for CRUD operations and authentication mechanisms.
 */
public interface EmployeeDAO {

    /**
     * Saves a new employee's credentials and profile data into the database.
     *
     * @param employee The Employee object to be saved.
     * @return true if the operation was successful, false otherwise.
     */
    public boolean save(Employee employee);

    /**
     * Retrieves a list of all employees from the database.
     *
     * @return A List of Employee objects.
     */
    public List<Employee> getAllEmployee();

    /**
     * Retrieves a specific employee record based on username.
     *
     * @param username The unique username of the employee.
     * @return An Employee object if found, null otherwise.
     */
    public Employee getEmployee(String username);

    /**
     * Authenticates the user by checking the provided credentials against the database.
     *
     * @param username The entered username.
     * @param password The entered password.
     * @return true if authentication is successful, false otherwise.
     */
    public boolean isAuthenticated(String username, String password);
}
