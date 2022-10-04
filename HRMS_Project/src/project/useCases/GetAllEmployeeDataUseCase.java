package project.useCases;

import java.util.List;

import project.bean.Employee;
import project.dao.EmployeeDao;
import project.dao.EmployeeDaoImpl;
import project.exceptions.EmployeeException;

public class GetAllEmployeeDataUseCase {
	
	public void getAllEmployeeDetails() {
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			List<Employee> employees = dao.getAllEmployeeDetails();
			employees.forEach(s-> {
				System.out.println("Employee Id: "+ s.getId());
				System.out.println("Employee name: "+ s.getfName()+" "+s.getlName());
				System.out.println("Employee Salary: "+ s.getSalary());
				System.out.println("Employee Email: "+ s.getEmail());
				System.out.println("Employee Mobile: "+ s.getMobile());
				System.out.println("Employee Password: "+ s.getPasswd());
				System.out.println("----------------------------------- \n");
			}); 
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
	}

}
