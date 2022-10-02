package project.useCases;

import java.util.Scanner;

import project.dao.UpdateEmpProfileDao;

public class UpdateProfileEmpUseCase {
	
	public void updateEmpProfile(int id) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("------------------------------------");
		System.out.println("\n"
				+ "1. Update name \n"
				+ "2. Update email \n"
				+ "3. Update mobile number \n"
				+ "4. Update password \n"
				+ "5. Exit");
		System.out.println("\nPlease enter one option to continue");
		int i = sc.nextInt();
		
		switch(i) {
		case 1:
			String name = new UpdateEmpProfileDao().updateName(id);
			System.out.println(name);
			break;
		case 2:
			String email = new UpdateEmpProfileDao().updateEmail(id);
			System.out.println(email);
			break;
		case 3:
			String mobile = new UpdateEmpProfileDao().updateMobile(id);
			System.out.println(mobile);
			break;
		case 4:
			String password = new UpdateEmpProfileDao().updatePassword(id);
			System.out.println(password);
			break;
		case 5:
			System.out.println("Thank You....!");
			return;
			
		}
		
		
	}
}
