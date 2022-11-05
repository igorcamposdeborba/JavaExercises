package abstractIncomeTax;

public class Company extends TaxPayer {

	private int associates;
	
	public Company (String name, double income, int associates) {
		super(name, income);
		this.associates = associates;
	}
	
	// Access method
	public int getAssociates() {
		return associates;
	}
	public void setAssociates(int associates) {
		this.associates = associates;
	}
	
	
	// Logic method
	@Override
	public double incomeTax() {
		double calc;
		
		if (getAssociates() > 10) {
			calc = getIncome() * 0.14;
			
		} else {
			calc = getIncome() * 0.16;
		}
		
		return calc;
	}
}
