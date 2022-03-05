package financialBank;

public class CurrentAccount extends AccountBank {
	private int transaction;

	public CurrentAccount (String password) {
		super(password);
	}

	@Override
	public void withdraw(double value) {
		setBalance(getBalance() - value);
		transaction++;
	}
	
	@Override
	public void deposit(double value) {
		setBalance(getBalance() + value);
		transaction++;
	}
	
	@Override
	public void statement() {
		System.out.println(this.toString()); 
		transaction++;
	}

	public int getTransaction() {
		return transaction;
	}
	
	@Override
	public String toString() {
		return "CurrentAccount [transaction=" + transaction + ", toString()=" + super.toString() + "]";
	}
}
