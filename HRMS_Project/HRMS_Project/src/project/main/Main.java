package project.main;

import java.util.Scanner;

import project.admin.Admin;
import project.dao.EmplApplyForLeaves;
import project.useCases.EmployeeLoginUseCase;
import project.useCases.UpdateProfileEmpUseCase;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("...............Welcome to Human Resource Management System...............");
		
		boolean flag = false;
		
		while(flag==false) {
			
			System.out.println("\n"
					+ "1. Admin \n"
					+ "2. Employee \n"
					+ "3. Exit");
			System.out.println("\nPlease enter one option to continue: ");
			int choise = sc.nextInt();
			
			if(choise==1 || choise == 2 || choise == 3){
				flag = true;
				switch(choise) {
				case 1:
					System.out.println("===========================");
					System.out.println("\nWelcome to Admin pannel");
					
					Admin admin = new Admin();
					
					boolean Adminflag = admin.AdminLogin();
					
					if(Adminflag) {
						System.out.println("Login sucessfull..!");
						admin.adminPannel();
					}else {
						System.out.println("Wrong Userid or Password....!");
					}
					break;
					
				case 2:
					System.out.println("============================");
					System.out.println("\nWelcome to Employee pannel\n");
					EmployeeLoginUseCase empLogin = new EmployeeLoginUseCase();
					int id = empLogin.employeeLogin();
					System.out.println("\n"
							+ "1. Apply for leave \n"
							+ "2. Profile update \n"
							+ "3. Exit \n");
					
					System.out.println("Please enter one option");
					int option = sc.nextInt();
					if(option==1){
						String msg = new EmplApplyForLeaves().applyForLeaves(id);
						System.out.println("msg");
					}else if(option==2) {
						new UpdateProfileEmpUseCase().updateEmpProfile(id);
					}else if(option==3) {
						System.out.println("Thank You....!");
						return;
					}
					break;
				case 3:
					System.out.println("Thank you......!");
					return;
				}
			}else {
				System.out.println("Wrong input");
				flag = false;
			}
		}	
	}

}
