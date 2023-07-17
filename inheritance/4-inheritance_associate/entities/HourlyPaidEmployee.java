package entities;

public class HourlyPaidEmployee extends Employee {
	private double hourlyRate;
	private int hoursWorked;
	
	public HourlyPaidEmployee(int employeeID, String name, double hourlyRate, int hoursWorked) {
		super(employeeID, name);
		
		this.hourlyRate = hourlyRate;
		this.hoursWorked = hoursWorked;
	}
	
	// Access methods
	public double getHourlyRate() {
		return hourlyRate;
	}
	public int getHoursWorked() {
		return hoursWorked;
	}
	
	public void setHourlyRate(int hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	public void setHoursWorked(int hoursworked) {
		this.hoursWorked = hoursworked;
	}
	
	// Logic method
	@Override
	public double calculateSalary() {
		return this.hourlyRate * this.hoursWorked; // R$ 2.00  *  10 horas
	}
	
	@Override
	public String toString() {
		return "Nome: " + super.getName() + ", Salario: R$ " + String.format("%.2f", calculateSalary()) ;
	}
}
