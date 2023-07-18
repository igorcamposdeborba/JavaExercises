package principal;

import entities.BankAccount;
import entities.SavingsAccount;

public class Principal {
	public static void main(String [] args) {
		BankAccount acc1 = new SavingsAccount();
		System.out.println("SALDO INICIAL: " + acc1 + "\n");
		acc1.deposit(1000.00);
		System.out.println("DEPOSITO de R$ 1000,00: " + acc1.getBalance());
		
		acc1.withdraw(600.0);
		System.out.printf("SAQUE de R$ 600,00: \t%.2f", acc1.getBalance());
	}
}
