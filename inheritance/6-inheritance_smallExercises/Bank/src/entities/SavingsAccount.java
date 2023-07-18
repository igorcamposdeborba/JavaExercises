package entities;

public class SavingsAccount extends BankAccount {

	public SavingsAccount() {
		super();
	}
	
	@Override
	public void withdraw(double inputwithdraw) throws IllegalArgumentException {
		if (super.getBalance() - inputwithdraw < 100.0) {
			throw new IllegalArgumentException("saque maior do que o que voce possui de saldo na conta. Saldo atual: R$ " + String.format("%.2f", super.getBalance()));
		}
		super.withdraw(inputwithdraw);
	}
}
