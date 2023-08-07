package entities;

public class Manager extends Associate {
	
	private double salaryAllowance;
	
	public Manager(Person person, Associate associate, double salaryAllowance) {
		super(person.getName(), 
			  person.getAddress(),
			  person.getAddress(), 
			  associate.getSectorCode(), 
			  associate.getBaseSalary(), 
			  associate.getTaxBase());
			  
	     this.salaryAllowance = salaryAllowance;
	}
	
	// Access methods
	public double getSalaryAllowance() {
		return salaryAllowance;
	}
	public void setSalaryAllowance(double salaryAllowance) {
		this.salaryAllowance = salaryAllowance;
	}
	
	@Override
	public double salary() {
		return super.salary() + this.salaryAllowance; // Note: don't discount salaryAllowance on tax
	}
}
