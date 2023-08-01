package entities;

public class Associate {
	private String name;
	protected float salary;
	
	public Associate(String name, float salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	public float getSalary() {
		return salary;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Nome: " + name + ", Salario: " + String.format("%.2f", salary);
	}
	
}	
