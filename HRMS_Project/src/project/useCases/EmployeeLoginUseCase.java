package project.useCases;

import java.util.Scanner;

import project.bean.Employee;
import project.dao.EmployeeDao;
import project.dao.EmployeeDaoImpl;
import project.exceptions.EmployeeException;

public class EmployeeLoginUseCase {
	
	public int employeeLogin() {
		
		boolean flag = false;
		int loginId = 0;
		Scanner sc = new Scanner(System.in);
		while(flag == false) {
			System.out.println("Enter user name: ");
			String username = sc.next();
			System.out.println("Enter password ");
			String password = sc.next();
			
			EmployeeDao dao = new EmployeeDaoImpl();
			try {
				Employee employee = dao.loginEmployee(username, password);
				
				System.out.println("\nWelcome "+employee.getfName());
				System.out.println("-----------------------");
				
				System.out.println("Id: "+employee.getId());
				System.out.println("Name: "+employee.getfName()+" "+employee.getlName());
				System.out.println("Salary: "+employee.getSalary());
				System.out.println("Email: "+employee.getEmail());
				System.out.println("Mobile number: "+employee.getMobile());
				
				System.out.println("-----------------------");
				flag = true;
				loginId = employee.getId();
			} catch (EmployeeException e) {
				
				System.out.println(e.getMessage());;
			}
		}
		return loginId;
	}
	
}
