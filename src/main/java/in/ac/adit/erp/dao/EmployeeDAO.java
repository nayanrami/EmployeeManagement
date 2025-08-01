package in.ac.adit.erp.dao;

import java.util.List;

import in.ac.adit.erp.model.Employee;

public interface EmployeeDAO {
	public boolean save(Employee employee);

	public List<Employee> getAllEmployee();

	public Employee getEmployee(String username);

	public boolean isAuthenticated(String username, String password);
}
