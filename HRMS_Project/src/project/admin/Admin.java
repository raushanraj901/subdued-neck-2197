package project.admin;

import java.util.Scanner;

import project.useCases.AddDeptImplUseCase1;
import project.useCases.RegisterEmplUseCase1;

public class Admin {
	
	Scanner sc = new Scanner(System.in);
	
	public boolean AdminLogin() {
		
		System.out.println("Enter user id: ");
		String adminUserId = sc.next();
		System.out.println("Enter password: ");
		int password = sc.nextInt();
		
		if(adminUserId.equals("admin") && password==12345) {
			return true;
		}else {
			return false;
		}
	}
	
	public void adminPannel() {
		System.out.println("\n"
				+ "1. Add department \n"
				+ "2. View department \n"
				+ "3. Update department \n"
				+ "4. Register new employee \n"
				+ "5. Employee transfer to the other department \n"
				+ "6. Employee leave");
		
		System.out.println("Please choose one option to continue");
		int adminChoise = sc.nextInt();
		
		switch(adminChoise) {
		case 1:
			AddDeptImplUseCase1 deptAdd = new AddDeptImplUseCase1();
			deptAdd.newDepartmentAdd();
			break;
		case 2:
			
			break;
		case 3:
			break;
		case 4:
			RegisterEmplUseCase1 regEmp = new RegisterEmplUseCase1();
			regEmp.employeeRegistration();
			break;
		case 5:
			break;
		case 6:
			break;
		}
	}
	

}
