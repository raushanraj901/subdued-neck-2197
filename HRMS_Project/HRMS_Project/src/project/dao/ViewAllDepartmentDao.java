package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.utility.DBConnection;

public class ViewAllDepartmentDao {
	
	public void viewDepartment() {
			
			try(Connection conn = DBConnection.provideConnection()) {
				
			PreparedStatement ps = conn.prepareStatement("select * from department");
				
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int dpId = rs.getInt("deptId");
				String dpName = rs.getString("deptName");
				System.out.println("Id: " +dpId);
				System.out.println("Name: "+dpName);
				System.out.println("--------------------- \n");
			}
			
			} catch (SQLException e) {
				e.getMessage();
		}
	}
}
