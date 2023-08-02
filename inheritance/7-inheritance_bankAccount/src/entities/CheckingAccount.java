package entities;

import java.util.Objects;

public class CheckingAccount {
	protected float balance;
	
	protected Client client;
	
	public CheckingAccount () {}
	public CheckingAccount (Client client, float balance) {
		this.balance = balance;
		
		this.client = client;
	}
	
	// Access methods
	public float getBalance() {
		return balance;
	}
	
	// Logic methods
	public void deposit(float amount) {
		this.balance += amount;
	}
	
	public boolean withdraw(float amount){
		boolean isValidWithdraw = false;
		
		if (balance - amount >= balance) {
			isValidWithdraw = true;
			this.balance = this.balance - amount;
		}
		return isValidWithdraw;
	}
	
	public boolean transfer(CheckingAccount checkingAccount) {
		boolean isValidToTransfer = false;
		if (checkingAccount.getBalance() > this.getBalance()) { // O parâmetro é maior ou igual ao saldo na conta? Sim, então libere a transação
			isValidToTransfer = true;
		}
		return isValidToTransfer;
	}
	
	// Composition method
	public Client getClient() {
		return this.client;
	}
	public void setClient(Client client) throws IllegalStateException {
		if (Objects.isNull(client) || !this.equals(client)) {
			throw new IllegalStateException("Nao eh possivel trocar o dono da conta porque ja existe um dono");
		}
		else if (Objects.nonNull(client)) {
			this.client = client;
		}
	}
	
	@Override
	public String toString() {
		return "Cliente - " + this.client + ", saldo: R$ " + this.balance;
	}
}
