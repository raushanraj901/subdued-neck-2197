package project.bean;

public class EmployeeDeptData {
	
	private int Id;
	private String fName;
	private String lName;
	private String email;
	private String mobile;
	private int dId;
	private String dName;
	
	
	public EmployeeDeptData() {
		
	}


	public EmployeeDeptData(int id, String fName, String lName, String email, String mobile, int dId, String dName) {
		super();
		Id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.mobile = mobile;
		this.dId = dId;
		this.dName = dName;
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


	public int getdId() {
		return dId;
	}


	public void setdId(int dId) {
		this.dId = dId;
	}


	public String getdName() {
		return dName;
	}


	public void setdName(String dName) {
		this.dName = dName;
	}


	@Override
	public String toString() {
		return "EmployeeDeptData [Id=" + Id + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", mobile="
				+ mobile + ", dId=" + dId + ", dName=" + dName + "]";
	}

}
