package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import project.bean.Employee;
import project.bean.EmployeeDeptData;
import project.exceptions.DepartmentException;
import project.exceptions.EmployeeException;
import project.useCases.AllocateEmployeeToDepartment;
import project.utility.DBConnection;

public class EmployeeDaoImpl implements EmployeeDao{
	
	Scanner sc = new Scanner(System.in);
	@Override
	public String registerEmp(Employee employee) {
		
		String msg = "Not Inserted..!";
		
		try(Connection conn = DBConnection.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement
			("insert into employee(F_Name,L_Name,Salary,Email,Mobile_Num,Password) values(?,?,?,?,?,?)");
			
		ps.setString(1, employee.getfName());
		ps.setString(2, employee.getlName());
		ps.setInt(3, employee.getSalary());
		ps.setString(4, employee.getEmail());
		ps.setString(5, employee.getMobile());
		ps.setString(6, employee.getfName());
		
		int x = ps.executeUpdate();
		
		if(x>0) {
			msg = "Employee Registered Sucessfully";
			System.out.println("Are you want to allocate department y/n ?");
			
			String allocDept = sc.next();
			if(allocDept.charAt(0)=='y') {
				AllocateEmployeeToDepartment allocdept = new AllocateEmployeeToDepartment();
				allocdept.allocateDeptToEmployee();
			}else {
				System.out.println("Thank you..!");
			}
			
		}
		
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		
		return msg;
	}
	
	@Override
	public Employee loginEmployee(String username, String Password) throws EmployeeException {
		
		Employee employee = null;
		
		try(Connection conn = DBConnection.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from employee where Email = ? AND Password = ?");
			ps.setString(1, username);
			ps.setString(2, Password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int i = rs.getInt("ID");
				String f = rs.getString("F_Name");
				String l = rs.getString("L_Name");
				int s = rs.getInt("Salary");
				String e = rs.getString("Email");
				String m = rs.getString("Mobile_Num");	
				
			employee = new Employee();
			employee.setId(i);
			employee.setfName(f);
			employee.setlName(l);
			employee.setSalary(s);
			employee.setEmail(e);
			employee.setMobile(m);
		
			
			
			}else {
				throw new EmployeeException("Invalid username or password....!\n");
			}
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return employee;
	}

	@Override
	public List<Employee> getAllEmployeeDetails() throws EmployeeException {
		List<Employee> employees = new ArrayList<>();
		
		try(Connection conn = DBConnection.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from employee");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int i = rs.getInt("ID");
				String f = rs.getString("F_Name");
				String l = rs.getString("L_Name");
				int s = rs.getInt("Salary");
				String e = rs.getString("Email");
				String m = rs.getString("Mobile_Num");
				String p = rs.getString("Password");
					
				Employee employee = new Employee();
				employee.setId(i);
				employee.setfName(f);
				employee.setlName(l);
				employee.setSalary(s);
				employee.setEmail(e);
				employee.setMobile(m);
				employee.setPasswd(p);
				
				employees.add(employee);
			}
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		if(employees.size() == 0) {
			throw new EmployeeException("No employee found...!");
		}
		
		
		return employees;
	}

	@Override
	public String registerEmplInsideDept(int eId, int deptId) throws EmployeeException, DepartmentException {
		
		
		String msg = "Not registered";
		
		try(Connection conn = DBConnection.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from employee where ID=?");
			
			ps.setInt(1, eId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				PreparedStatement ps2 = conn.prepareStatement("select * from department where deptId = ?");
				ps2.setInt(1, deptId);
				
				ResultSet rs2 = ps.executeQuery();
				
				if(rs2.next()) {
					
					PreparedStatement ps3 = conn.prepareStatement("inser into dept_empl values(?,?)");
					
					ps3.setInt(1, eId);
					ps3.setInt(2, deptId);
					
					int x = ps3.executeUpdate();
					
					if(x>0) {
						msg = "Employee registered inside the department sucessfully.....!";
					}else {
						throw new EmployeeException("Technical Error..!");
						
					}
					
				}else {
					throw new DepartmentException("Invalid department....!");
				}
				
			}else {
				throw new EmployeeException("Invalid Employee Id....!");
			}
			
		
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		return msg;
	}

	@Override
	public List<EmployeeDeptData> getAllEmployeeByDname(String Dname) throws DepartmentException {
		
		List<EmployeeDeptData> eD = new ArrayList<>();
		
		try(Connection conn =  DBConnection.provideConnection()) {
		
			PreparedStatement ps = conn.prepareStatement("select "
					+ "e.ID e.F_Name,"
					+ "e.L_Name,e.Email,"
					+ "e.Mobile_Num,d.deptId,"
					+ "d.deptName from employee e "
					+ "INNER JOIN department d "
					+ "INNER JOIN dept_empl de "
					+ "ON e.ID = de.empl_Id "
					+ "AND d.deptId = de.dept_Id "
					+ "AND d.deptName=?;");
			
			ps.setString(1, Dname);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int i = rs.getInt("ID");
				String f = rs.getString("F_Name");
				String l = rs.getString("L_Name");
				String e = rs.getString("Email");
				String m = rs.getString("Mobile_Num");
				int dId = rs.getInt("deptId");
				String dName = rs.getString("deptName");
				
				EmployeeDeptData employee = new EmployeeDeptData();
				eD.add(employee);
			}
			
		} catch (SQLException e) {
			throw new DepartmentException(e.getMessage());
		}
		
		if(eD.isEmpty()) {
			throw new DepartmentException("No employee found...!");
		}
		
		
		return eD;
	}
	
	

}
