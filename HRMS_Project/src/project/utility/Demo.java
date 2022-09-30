package project.utility;

import java.sql.Connection;

public class Demo {

	public static void main(String[] args) {
		Connection conn = DBConnection.provideConnection();
		
		System.out.println(conn);
	
	}

}
