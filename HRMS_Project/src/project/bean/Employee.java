package project.bean;

public class Employee {
	
	private int Id;
	private String fName;
	private String lName;
	private int salary;
	private String email;
	private String mobile;
	private String dept;
	
	public Employee() {
		
	}

	public Employee(int id, String fName, String lName, int salary, String email, String mobile, String dept) {
		super();
		Id = id;
		this.fName = fName;
		this.lName = lName;
		this.salary = salary;
		this.email = email;
		this.mobile = mobile;
		this.dept = dept;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", fName=" + fName + ", lName=" + lName + ", salary=" + salary + ", email="
				+ email + ", mobile=" + mobile + ", dept=" + dept + "]";
	}
	
	
}
