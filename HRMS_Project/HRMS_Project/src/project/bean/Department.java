package project.bean;

public class Department {
	
	private int id;
	private String dName;
	
	public Department() {
	
	}
	
	public Department(int id, String dName) {
		super();
		this.id = id;
		this.dName = dName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", dName=" + dName + "]";
	}
	
}
