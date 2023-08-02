package entities;

import java.util.ArrayList;

public class Client {
	private String name;
	
	// Composition
	private ArrayList<CheckingAccount> checkingAccountList = new ArrayList<>();
	
	public Client() {}
	public Client(String name) {
		this.name = name;
	}
	
	// Access methods
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// Logic methods
	public ArrayList<CheckingAccount> getCheckingAccountList() {
		return this.checkingAccountList;
	}
	public void addCheckingAccount(CheckingAccount checkingAccount) {
		this.checkingAccountList.add(checkingAccount);
	}
	
	@Override
	public String toString() {
		return "Nome: " + this.name;
	}
}
