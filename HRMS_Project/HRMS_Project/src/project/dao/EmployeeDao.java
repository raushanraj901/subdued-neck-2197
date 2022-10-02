package project.dao;

import java.util.List;

import project.bean.Employee;
import project.bean.EmployeeDeptData;
import project.exceptions.DepartmentException;
import project.exceptions.EmployeeException;

public interface EmployeeDao {
	
	public String registerEmp(Employee employee);
	
	public Employee loginEmployee(String username, String Password) throws EmployeeException;
	
	public List<Employee> getAllEmployeeDetails() throws EmployeeException;
	
	public String registerEmplInsideDept(int eId, int deptId) throws EmployeeException, DepartmentException; 

	public List<EmployeeDeptData> getAllEmployeeByDname(String Dname) throws DepartmentException;
}
