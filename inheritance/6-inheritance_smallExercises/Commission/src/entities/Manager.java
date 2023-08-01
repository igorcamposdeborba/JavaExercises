package entities;

public class Manager extends Associate {
	private String department;
	
	public Manager(Associate associate, String department) {
		super(associate.getName(), associate.getSalary());
		
		this.department = department;
	}
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Departamento: " + this.department;
	}
}
