package project.useCases;

import java.util.Scanner;

import project.bean.Department;
import project.dao.DepartmentDao;
import project.dao.DepartmentDaoImpl;


public class AddDeptImplUseCase1 {
	
	public void newDepartmentAdd() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter department name: ");
		String deptName = sc.next();
		
		DepartmentDao Dao = new DepartmentDaoImpl();
		
		Department department = new Department();
		department.setdName(deptName);
		
		String result = Dao.addDept(deptName);
		
		System.out.println(result);
		
		
	}

}
