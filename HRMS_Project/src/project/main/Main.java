package project.main;

import java.util.Scanner;

import project.admin.Admin;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("...............Welcome to Human Resource Management System...............");
		
		System.out.println("\n1. Admin \n2. Employee \n");
		
		System.out.println("Please enter one option to continue: \n");
		int choise = sc.nextInt();
		
		if(choise==1 || choise == 2){
			switch(choise) {
			case 1:
				System.out.println("Welcome to Admin pannel");
				
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
				
				System.out.println("Welcome to Employee pannel");
				break;
			}
		}else {
			System.out.println("Wrong input");
		}
	}

}
