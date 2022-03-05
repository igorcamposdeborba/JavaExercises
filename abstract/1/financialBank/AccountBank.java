package financialBank;

import java.util.Scanner;

public abstract class AccountBank {
	private String password;
	private int accountId;
	private double balance;

	
	public abstract void withdraw(double value);
	public abstract void deposit(double value);
	public abstract void statement();
	
	public AccountBank(String password) {
		this.password = password;
	}
	public AccountBank(String password, int accountId) {
		this.accountId = accountId;
		this.password = password;		
	}
	public AccountBank(String password, int accountId, double balance) {
		this.accountId = accountId;
		this.password = password;
		this.balance = balance;
	}
	
	public int getAccountId() {
		return accountId;
	}
	public String getPassword() {
		return password;
	}
	public double getBalance() {
		return balance;
	}
	
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public void setBalance(double balance) {
		this.balance = balance ;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean changePassword(String password) {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite a senha anterior:");
		if (input.nextLine().equals(password)) {
			this.password = password; 
			return true;
		}
		return false;
	}
	
	
	
	public String toString() {
		return "Conta bancária [password=" + password + ", accountId=" +  accountId + ", statement=" + balance + "]";
	}
	
}
