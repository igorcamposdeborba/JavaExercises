package entities;

public class Associate {
	String name;
	String email;
	double salary;
	
	public Associate(String name, String email, double salary) {
		this.name = name;
		this.email = email;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public double getSalary() {
		return salary;
	}
	
	
}
