package in.ac.adit.erp.dao;

import java.sql.*;
import java.util.List;
import in.ac.adit.erp.model.Employee;

/**
 * EmployeeDAOImpl provides concrete implementations of EmployeeDAO interface.
 * It uses JDBC with PreparedStatement to securely interact with the MySQL database.
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    private final String DBNAME = "erp_db";
    private final String DBUSER = "root";
    private final String DBPASSWORD = "NEO007007";
    private final String CONURL = "jdbc:mysql://localhost:3306/" + DBNAME;

    static Connection connection;
    PreparedStatement pstm;
    ResultSet resultSet;

    /**
     * Constructor that initializes the database connection.
     */
    public EmployeeDAOImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(CONURL, DBUSER, DBPASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Load Driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Constructor Error: " + e.getMessage());
        }
    }

    /**
     * Saves the employee login credentials and personal details into two separate tables.
     *
     * @param employee The Employee object to be saved.
     * @return true if both inserts succeed, false otherwise.
     */
    @Override
    public boolean save(Employee employee) {
        try {
            pstm = connection.prepareStatement("insert into login_tbl (username,password) values (?,?)");
            pstm.setString(1, employee.getUsername());
            pstm.setString(2, employee.getPassword());
            pstm.execute();

            pstm = connection.prepareStatement(
                "insert into employee_info_tbl (username,firstname,lastname,email,mobileno,designation,gender) values(?,?,?,?,?,?,?)"
            );
            pstm.setString(1, employee.getUsername());
            pstm.setString(2, employee.getFirstname());
            pstm.setString(3, employee.getLastname());
            pstm.setString(4, employee.getEmail());
            pstm.setString(5, employee.getMobileno());
            pstm.setString(6, employee.getDesignation());
            pstm.setString(7, employee.getGender());
            pstm.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Retrieves all employee records from the database.
     * (Currently not implemented)
     *
     * @return A list of all Employee objects.
     */
    @Override
    public List<Employee> getAllEmployee() {
        // TODO: Implement fetching of all employees
        return null;
    }

    /**
     * Retrieves a specific employee based on username.
     * (Currently not implemented)
     *
     * @param username The username of the employee.
     * @return An Employee object or null.
     */
    @Override
    public Employee getEmployee(String username) {
        // TODO: Implement employee lookup by username
        return null;
    }

    /**
     * Checks if the provided credentials match a record in the login table.
     *
     * @param username The username.
     * @param password The password.
     * @return true if credentials match, false otherwise.
     */
    @Override
    public boolean isAuthenticated(String username, String password) {
        try {
            pstm = connection.prepareStatement("select username from login_tbl where username = ? and password = ?");
            pstm.setString(1, username);
            pstm.setString(2, password);
            resultSet = pstm.executeQuery();
            return resultSet.next(); // Returns true if a record is found
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
