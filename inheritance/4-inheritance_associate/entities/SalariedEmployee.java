package entities;

public class SalariedEmployee extends Employee {
	private double monthlySalary;
	
	
	public SalariedEmployee(int employeeID, String name, double monthlySalary) throws IllegalArgumentException {
		super(employeeID, name);
		if (monthlySalary < 1320.00) { // exception para verificar se o objeto tem pelo menos o salário mínimo
			throw new IllegalArgumentException("O salario instanciado eh menor que um salario minimo."); // para não deixar instanciar menos que um salário mínimo por funcionário
		}
		this.monthlySalary = monthlySalary;
	}
	
	// Access methods
	public double getMonthlySalary(){
		return monthlySalary;
	}
	
	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	
	// Logic methods
	@Override
	public double calculateSalary() {
		return this.monthlySalary;
	}
	
	@Override
	public String toString() {
		return "Associado: " + this.getName() + ", Salario: R$ " + String.format("%.2f", this.monthlySalary);
	}
}
