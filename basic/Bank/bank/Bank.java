package bank;

public class Bank {
	private static int ID;
	private String name;
	private double balance;
	private static final double TAX = 5.00;
	
	public Bank(int ID, String name) {
		this.ID = ID;
		this.name = name;
	}
	
	public void setInitialDeposit(double value) {
		this.balance = value;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void deposit(double value) {
		this.balance += value;
	}
	
	public void withdray(double value) throws IllegalArgumentException {
		if (value > this.balance) {
			throw new IllegalArgumentException("Saque maior que o saldo");
		}
		if (this.balance - (value + this.TAX) > 0) {
			this.balance -= value + this.TAX;
		} else {
			throw new IllegalArgumentException("Nao ha saldo para cobrir a taxa de R$ " + TAX + "0");
		}
	}
	
	public int getId() {
		return this.ID;
	}
	public String getName() {
		return this.name;
	}
	public double getBalance() {
		return balance;
	}
	
	
}
