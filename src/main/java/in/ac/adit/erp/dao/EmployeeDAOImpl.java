package in.ac.adit.erp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import in.ac.adit.erp.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	private final String DBNAME = "erp_db";
	private final String DBUSER = "root";
	private final String DBPASSWORD = "NEO007007";
	private final String CONURL = "jdbc:mysql://localhost:3306/" + DBNAME;

	static Connection connection;
	PreparedStatement pstm;
	ResultSet resultSet;

	public EmployeeDAOImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(CONURL, DBUSER, DBPASSWORD);
		} catch (ClassNotFoundException e) {
			System.out.println("Load Driver"+e.getMessage());
		} catch (SQLException e) {
			System.out.println("Constructor Error " + e.getMessage());
		}
	}

	@Override
	public boolean save(Employee employee) {

		try {
			pstm = connection.prepareStatement("insert into login_tbl (username,password) values (?,?)");
			pstm.setString(1, employee.getUsername());
			pstm.setString(2, employee.getPassword());
			pstm.execute();

			pstm = connection.prepareStatement(
					"insert into employee_info_tbl (username,firstname,lastname,email,mobileno,designation,gender) values(?,?,?,?,?,?,?)");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployee(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAuthenticated(String username, String password) {
		try {
			pstm = connection.prepareStatement("select username from login_tbl where username = ? and password = ?");
			pstm.setString(1, username);
			pstm.setString(2, password);

			pstm.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
