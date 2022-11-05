package abstractIncomeTax;

public abstract class TaxPayer {
	private String name;
	private double income;
	
	public TaxPayer(String name, double income) {
		this.name = name;
		this.income = income;
	}
	
	// Access methods
	public String getName() {
		return name;
	}
	public double getIncome() {
		return income;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	
	
	// Logic method
	public abstract double incomeTax();
}
