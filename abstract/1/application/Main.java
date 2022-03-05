package application;

import java.util.Scanner;

import financialBank.AccountBank;
import financialBank.CurrentAccount;
import financialBank.Rentable;
import financialBank.SavingAccount;

public class Main {
	public static void main (String [] args) {
		Scanner input = new Scanner(System.in);
		
		int accountQuantity = 0;
		
		while (accountQuantity <= 0) {
			System.out.println("Digite o número de contas que você deseja criar");
			accountQuantity =  Integer.parseInt(input.nextLine());
		}
		
		AccountBank[] accounts = new AccountBank[accountQuantity];

		String savedPassword = null;

		for (int i=0; i < accounts.length; i++) {
			System.out.println("Digite 1 para conta-corrente e 2 para conta salário");
					
			if (Integer.parseInt(input.nextLine()) == 1) {
				System.out.println("Digite a senha:");
				savedPassword = input.nextLine();
				accounts[i] = new SavingAccount(savedPassword);
			
			} else {
				System.out.println("Digite a senha:");
				savedPassword = input.nextLine();
				accounts[i] = new CurrentAccount(savedPassword);
			}
		}
	
		// gerar número aleatório da conta
		for (AccountBank account : accounts) {
			account.setAccountId((int) Math.random() * 1000 +1);
			
		}
		// gerar taxa de rendimento da poupança
		for (int i=0; i < accounts.length; i++) {
			for (AccountBank account : accounts) {
				if (account instanceof SavingAccount) {
					((SavingAccount) account).setSavingsRate(Math.random());
				}
			}
			
			// sacar, depositar e tirar extrato de cada conta
			for (AccountBank account : accounts) {
				account.deposit(Math.random() * 1000 +1);
				account.withdraw(Math.random() * 100 +1);
				account.getBalance();
			}
		}
		
		// rendimento da poupança e quantidade de transações
		for (AccountBank i : accounts) {
			if (i instanceof SavingAccount) {
				System.out.println("Taxa de rendimento da poupança "+ i.getAccountId() + ": " + ((SavingAccount) i).getSavingsRate());
			
			} else if (i instanceof CurrentAccount) {
				System.out.println("Quantidade de transações da conta corrente: " + i.getAccountId() + ": " + ((CurrentAccount) i).getTransaction());
			}
		}
			
		Rentable [] rentable = new Rentable[(int)(Math.random()*10+1)];
		for (int i=0; i < rentable.length; i++) {
			if (Math.random() < 0.5) {
				rentable[i] = new SavingAccount(savedPassword);
			} else {
				rentable[i] = new SavingAccount(savedPassword);
			}
				
		}
		
		for (Rentable i : rentable) {
			System.out.println(i.calculateIncome());
		}

	}

}

