package project.useCases;

import java.util.Scanner;

import project.bean.Employee;
import project.dao.*;

public class RegisterEmplUseCase1 {

	public void employeeRegistration() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first name: ");
		String fname = sc.next();
		System.out.println("Enter last name: ");
		String lname = sc.next();
		System.out.println("Enter salary: ");
		int salary = sc.nextInt();
		System.out.println("Enter email: ");
		String email = sc.next();
		System.out.println("Enter mobile number: ");
		String mobile = sc.next();
		System.out.println("Enter department: ");
		String dname = sc.next();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		Employee employee = new Employee();
		employee.setfName(fname);
		employee.setlName(lname);
		employee.setSalary(salary);
		employee.setEmail(email);
		employee.setMobile(mobile);
		employee.setDept(dname);
		
		
		String result = dao.registerEmp(employee);
		
		System.out.println(result);
	}

}
