package project.useCases;

import java.util.List;
import java.util.Scanner;

import project.bean.EmployeeDeptData;
import project.dao.EmployeeDao;
import project.dao.EmployeeDaoImpl;
import project.exceptions.DepartmentException;

public class GetEmplByDeptNameUseCase {
	
	
	public void getEmployeeBydeptName(){
		
		Scanner sc = new Scanner(System.in);
		String deptN= sc.next();
		System.out.println("Enter department name: ");	
		EmployeeDao eDept = new EmployeeDaoImpl();
		
		try {
			List<EmployeeDeptData> empData = eDept.getAllEmployeeByDname(deptN);
			
			empData.forEach(s->System.out.println(s));
		
		} catch (DepartmentException e) {
			
			System.out.println(e.getMessage());
		}
		
	}

}
