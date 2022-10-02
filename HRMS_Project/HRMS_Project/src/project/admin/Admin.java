package project.admin;

import java.util.Scanner;

import project.dao.EmployeeTransferDao;
import project.dao.UpdateDepartmentDao;
import project.dao.ViewAllDepartmentDao;
import project.useCases.AddDeptImplUseCase1;
import project.useCases.GetAllEmployeeDataUseCase;
import project.useCases.GetEmplByDeptNameUseCase;
import project.useCases.RegisterEmplUseCase1;

public class Admin {
	
	Scanner sc = new Scanner(System.in);
	
	public boolean AdminLogin() {
		
		System.out.println("\nEnter user id: ");
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
				+ "4. View all employees details \n"
				+ "5. Register new employee \n"
				+ "6. All employee show there assigned department \n"
				+ "7. Employee leave \n"
				+ "8. Exit");
		
		System.out.println("Please choose one option to continue");
		int adminChoise = sc.nextInt();
		
		switch(adminChoise) {
		case 1:
			AddDeptImplUseCase1 deptAdd = new AddDeptImplUseCase1();
			deptAdd.newDepartmentAdd();
			adminPannel();
			break;
		case 2:
			
			ViewAllDepartmentDao vd = new ViewAllDepartmentDao();
			vd.viewDepartment();
			adminPannel();
			break;
		case 3:
			boolean deptupdateFlag = false;
			
			while(deptupdateFlag==false)
			
			deptupdateFlag = true;
			System.out.println("1. Update through department id \n"
					+ "2. Update through department name \n\n"
					+ "Please select one option");
			
			UpdateDepartmentDao ud = new UpdateDepartmentDao();
			int searchDept = sc.nextInt();
			
			if(searchDept==1) {
				System.out.println("Enter id: ");
				int dId = sc.nextInt();
				ud.UpdateDeptThroughId(dId);
			}else if(searchDept==2) {
				System.out.println("Enter name: ");
				String dName = sc.next();
				ud.UpdateDeptThroughName(dName);
				
			}else {
				System.out.println("Please choose valid option");
				deptupdateFlag = false;
			}
			adminPannel();
			break;
		case 4:
			GetAllEmployeeDataUseCase gAllEmptData = new GetAllEmployeeDataUseCase();
			gAllEmptData.getAllEmployeeDetails();
			adminPannel();
			break;
		case 5:
			RegisterEmplUseCase1 regEmp = new RegisterEmplUseCase1();
			regEmp.employeeRegistration();
			adminPannel();
			break;
		case 6:
			
			GetEmplByDeptNameUseCase geBydeptName = new GetEmplByDeptNameUseCase();
			geBydeptName.getEmployeeBydeptName();
			
			adminPannel();
			break;
		case 7:
			break;
		case 8: 
			
			System.out.println("Thank You......!");
			return;
		}
	}
	

}
