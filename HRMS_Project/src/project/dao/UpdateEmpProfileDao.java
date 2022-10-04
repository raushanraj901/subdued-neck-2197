package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import project.utility.DBConnection;

public class UpdateEmpProfileDao {
	
	Scanner sc = new Scanner(System.in);
	
	public String updateName(int id) {
		System.out.println("------------------------------------");
		String msg = "Not updated..!";
		
		try(Connection conn = DBConnection.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update employee set F_Name=?, L_Name=? where ID = ?");
			System.out.println("Enter first name: ");
			String fName = sc.next();
			System.out.println("Enter last name: ");
			String lName = sc.next();
			ps.setString(1,fName);
			ps.setString(2,lName);
			ps.setInt(3, id);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				msg = "Employee name updated sucessfully...!";
				
			}
			
			} catch (SQLException e) {
				msg = e.getMessage();
			}
			
		return msg;
	}
	
	public String updateEmail(int id) {
		
		String msg = "Not updated..!";
		
		try(Connection conn = DBConnection.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update employee set Email=? where ID = ?");
			System.out.println("Enter your email: ");
			String email = sc.next();
			ps.setString(1,email);
			ps.setInt(2, id);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				msg = "Employee email updated sucessfully...!";
			}
			
		} catch (SQLException e) {
			msg = e.getMessage();
		}
			
		return msg;
		
	}
	public String updateMobile(int id) {
		
		String msg = "Not updated..!";
		
		try(Connection conn = DBConnection.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update employee set Mobile_Num=? where ID = ?");
			System.out.println("Enter new mobile number: ");
			String mobile = sc.next();
			ps.setString(1,mobile);
			ps.setInt(2, id);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				msg = "Employee mobile number updated sucessfully...!";
			}
			
		} catch (SQLException e) {
			msg = e.getMessage();
		}
			
		return msg;
		
	}
	public String updatePassword(int id) {
		
		String msg = "Not updated..!";
		
		try(Connection conn = DBConnection.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update employee set Password=? where ID = ?");
			System.out.println("Enter new password: ");
			String password = sc.next();
			ps.setString(1,password);
			ps.setInt(2, id);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				msg = "Employee password updated sucessfully...!";
			}
			
		} catch (SQLException e) {
			msg = e.getMessage();
		}
			
		return msg;
		
	}
	
	
}
