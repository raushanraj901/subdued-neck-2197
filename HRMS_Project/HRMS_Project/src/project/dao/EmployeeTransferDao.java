package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import project.utility.DBConnection;

public class EmployeeTransferDao {
	
	public void getEmployeeById(int empId) {
		Scanner sc = new Scanner(System.in);
		String msg = "Employee not found..!";
		try(Connection conn = DBConnection.provideConnection()) {
			
			PreparedStatement ups = conn.prepareStatement("update employee set Department=? where ID=?");
			System.out.println("Enter new departname: ");
			String dName = sc.next();
			ups.setString(1,dName);
			ups.setInt(2, empId);
			
			int x = ups.executeUpdate();
			
			if(x>0) {
				msg = "Employee transferred Sucessfully...!";
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		System.out.println(msg);;
	}	

}
