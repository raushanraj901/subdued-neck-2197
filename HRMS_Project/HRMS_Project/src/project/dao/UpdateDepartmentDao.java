package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import project.utility.DBConnection;

public class UpdateDepartmentDao{
	
	Scanner sc = new Scanner(System.in);
	public void UpdateDeptThroughId(int deptId) {
		
		String msg = "Not found..!";
		boolean flag = false;
		while(flag==false) {
			try(Connection conn = DBConnection.provideConnection()) {
				
				PreparedStatement ps = conn.prepareStatement("update department set deptName=? where deptId = ?");
				System.out.println("Enter departname: ");
				String dName = sc.next();
				ps.setString(1,dName);
				ps.setInt(2, deptId);
				
				int x = ps.executeUpdate();
				
				if(x>0) {
					msg = "Department added Sucessfully";
					flag = true;
				}else {
					flag = false;
				}
				
				} catch (SQLException e) {
					msg = e.getMessage();
				}
				
				System.out.println(msg);
		}
		
	}
	
	public void UpdateDeptThroughName(String name) {
		
		String msg = "Not found..!";
		boolean flag = false;
		while(flag==false) {
			try(Connection conn = DBConnection.provideConnection()) {
				
				PreparedStatement ps = conn.prepareStatement("update department set deptName=? where deptName = ?");
				System.out.println("Enter new departname: ");
				String dName = sc.next();
				ps.setString(1,dName);
				ps.setString(2, name);
				
				int x = ps.executeUpdate();
				
				if(x>0) {
					msg = "Department name updated sucessfully...!";
					flag = true;
				}else {
					flag = false;
				}
				
				} catch (SQLException e) {
					msg = e.getMessage();
				}
				
				System.out.println(msg);
		}
	}

}
