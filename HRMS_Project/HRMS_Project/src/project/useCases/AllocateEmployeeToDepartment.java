package project.useCases;

import java.util.Scanner;

import project.dao.EmployeeDao;
import project.dao.EmployeeDaoImpl;
import project.exceptions.DepartmentException;
import project.exceptions.EmployeeException;

public class AllocateEmployeeToDepartment {
	
	public void allocateDeptToEmployee(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter employee id: ");
		int emplId = sc.nextInt();
		System.out.println("Enter Department id: ");
		int deptId = sc.nextInt();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			String result = dao.registerEmplInsideDept(emplId, deptId);
			System.out.println(result);
		} catch (EmployeeException e) {
			
			System.out.println(e.getMessage());
		} catch (DepartmentException e) {
			
			System.out.println(e.getMessage());
		}
		
	}

}
