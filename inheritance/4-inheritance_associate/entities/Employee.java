package entities;

public class Employee {
	private int employeeID;
	private String name;
	
	public Employee(int employeeID, String name) {
		this.employeeID = employeeID;
		this.name = name;
	}
	
	// Access methods
	public int getEmployeeID() {
		return employeeID;
	}
	public String getName() {
		return name;
	}
	
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double calculateSalary() { 
		return 1320.00; // salário mínimo. Esta é uma base de salário porque todo o funcionário deve receber pelo menos um salário mínimo
	}
}
