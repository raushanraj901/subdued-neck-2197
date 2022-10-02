package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.utility.DBConnection;

public class DepartmentDaoImpl implements DepartmentDao{

	public String addDept(String deptName) {
		
		String msg = "Not Inserted..!";
		
		try(Connection conn = DBConnection.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement
			("insert into department(deptName) values(?)");
			
		ps.setString(1,deptName);
		
		int x = ps.executeUpdate();
		
		if(x>0) {
			msg = "Department added Sucessfully";
		}
		
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		
		return msg;
		
	}
	
	

}
