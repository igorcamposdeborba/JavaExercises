package entities;

import java.util.UUID;

public class BankAccount {
	private UUID id;
	private double balance;

	public BankAccount() {
		this.id = UUID.randomUUID();
	}
	
	
	public double getBalance() {
		return balance;
	}
	public UUID getId() {
		return id;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
	}
	public void withdraw(double inputwithdraw) throws IllegalArgumentException {
		if (inputwithdraw > this.balance) {
			throw new IllegalArgumentException("saque maior do que o que voce possui de saldo na conta corrente");
		}
		this.balance -= inputwithdraw;
	}
	
	@Override
	public String toString() {
		return "Id: " + this.id + ", Saldo: " + String.format("%.2f", this.balance);
	}
	
}
