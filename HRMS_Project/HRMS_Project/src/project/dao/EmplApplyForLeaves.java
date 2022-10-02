package project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import project.utility.DBConnection;

public class EmplApplyForLeaves {
	
	public String applyForLeaves(int id) {
		String msg = "Not apply";
		
		try(Connection conn = DBConnection.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update EmpLeave set Starting_Date=?,Ending_Date = ? where ID = ?");
			System.out.println("Enter Strating Date: ");
			Scanner sc = new Scanner(System.in);
			String sdate = sc.next();
			String edate = sc.next();
//			ps.setDate(1,sdate);
//			ps.setDate(2,edate);
			ps.setInt(3,id);
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				msg = "Leave apply sucessfully...!";
				
			}
			
			} catch (SQLException e) {
				msg = e.getMessage();
			}
			
		return msg;
		
	}
}
