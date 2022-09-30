package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.bean.Employee;
import project.utility.DBConnection;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public String registerEmp(Employee employee) {
		
		String msg = "Not Inserted..!";
		
		try(Connection conn = DBConnection.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement
			("insert into employee(F_Name,L_Name,Salary,Email,Mobile_Num,Department) values(?,?,?,?,?,?)");
			
		ps.setString(1, employee.getfName());
		ps.setString(2, employee.getlName());
		ps.setInt(3, employee.getSalary());
		ps.setString(4, employee.getEmail());
		ps.setString(5, employee.getMobile());
		ps.setString(6, employee.getDept());
		
		int x = ps.executeUpdate();
		
		if(x>0) {
			msg = "Employee Registered Sucessfully";
		}
		
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		
		return msg;
	}

}
