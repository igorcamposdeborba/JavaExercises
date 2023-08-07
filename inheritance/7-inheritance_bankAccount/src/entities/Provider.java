package entities;

public class Provider extends Person {
	
	private double creditValue;
	private double debitValue;
	
	public Provider(String name, String address, String telephone, double creditValue, double debitValue) {
		super(name, address, telephone);
		
		this.creditValue = creditValue;
		this.debitValue = debitValue;
	}
	
	// Access methods
	public double getCreditValue() {
		return creditValue;
	}
	public double getDebitValue() {
		return debitValue;
	}
	
	public void addCreditValue(double creditValue) {
		this.creditValue += creditValue;
	}
	public void decreaseDebitValue(double debitValue) {
		this.debitValue = debitValue;
	}
	
	public double getAmount() {
		double resultAmount = this.creditValue - this.debitValue;
		return resultAmount;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Credito: R$ " + this.creditValue + ", Debito: R$ " + this.debitValue;
	}
}
