package entities;

public class SpecialAccount extends CheckingAccount {
	private float withdrawLimit;
	
	public SpecialAccount(Client client, float balance, float withdrawLimit) {
		super(client, balance);
		
		this.withdrawLimit = withdrawLimit;
	}

	@Override
	public boolean withdraw(float amount) {
		boolean isValidWithdraw = false;
		
		if (amount <= withdrawLimit) {
			isValidWithdraw = true;
			super.balance = super.balance - amount; // sacar: deduzir o valor do saldo, permitindo números negativos até o fator limite da conta
			// super.withdraw(amount);
		}
		return isValidWithdraw;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Limite de saque: R$ " + this.withdrawLimit;
	}
}
