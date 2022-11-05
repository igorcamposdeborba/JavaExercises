package withdrawException;

import java.util.Locale;
import java.util.Scanner;

public class Main {
	public static void main (String [] args) {
		
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite os dados da conta");
		System.out.print("Numero da conta: ");
		Integer idAccount = input.nextInt();
		input.nextLine(); // Buffer of int
		System.out.println("Titular: ");
		String holder = input.nextLine();
		
		System.out.print("Saldo inicial: ");
		final double INITIALBALANCE = input.nextDouble();
		input.nextLine(); // Buffer of int
		Double withdrawLimit = INITIALBALANCE * 0.7;
		System.out.println("Limite de saque: " + String.format("%.2f", withdrawLimit));
		
		
		try {			
			Account acc = new Account(idAccount, holder, INITIALBALANCE); // instantiate Account
			// input.nextLine(); // Buffer of int
			System.out.print("\nValor do saque: R$ ");
			acc.withdraw(input.nextDouble());
			
			System.out.println("Novo saldo: R$ " + String.format("%.2f", acc.getBalance()));
			
		} catch (withoutBalanceException e) { // Exception sacou mais do que o saldo da conta
			System.err.println(e);
			
		} catch (IllegalArgumentException e) { // Exception dados invalidos de criacao da conta
			System.err.println(e);
		}
		
		
	}
}
