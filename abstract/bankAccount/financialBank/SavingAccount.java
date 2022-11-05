package financialBank;

public class SavingAccount extends AccountBank implements Rentable {
	private double savingsRate;
	
	public SavingAccount (String password) {
		super(password);
	}
	
	@Override
	public void withdraw(double value) {
		setBalance(getBalance() - value);
	}
	
	@Override
	public void deposit(double value) {
		setBalance(getBalance() + value);
	}
	
	@Override
	public void statement() {
		System.out.println(this.toString());
	}
	
	public double getSavingsRate() {
		return savingsRate;
	}
	
	public void setSavingsRate(double tax) {
		savingsRate = tax;
	}
	
	// calcular rendimento da poupança
	public double calculateIncome(){
		return super.getBalance() * this.savingsRate;
	}
	
	// colocar um valor bônus
	public double bonusBalance() {
		return super.getBalance() * 5;
	}
	
	public String toString() {
		return "SavingsAccount [savingsRate=" + savingsRate + ", toString()=" + super.toString() + "]";
	}
}
