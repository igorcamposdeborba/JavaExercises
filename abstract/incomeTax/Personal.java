package abstractIncomeTax;

public class Personal extends TaxPayer {
	
	private double healthExpends;
	
	public Personal(String name, double income, double healthExpends) {
		super(name, income);
		this.healthExpends = healthExpends;
	}
	
	// Access methods
	public double getHealthExpends() {
		return healthExpends;
	}
	public void setHealthExpends(double healthExpends) {
		this.healthExpends = healthExpends;
	}
	
	
	// Logic methods
	@Override
	public double incomeTax() {
		
		double calc;
		if (getIncome() < 20000.00) {
			calc = getIncome() * 0.15 - healthExpends * 0.50;
			
		} else {
			calc = getIncome() * 0.25 - healthExpends * 0.50;
		}
		
		return calc;
	}
}
