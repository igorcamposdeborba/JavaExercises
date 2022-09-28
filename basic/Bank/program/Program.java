package program;

import java.util.Locale;
import java.util.Scanner;
import bank.Bank;

public class Program {

	public static void main (String [] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite o numero da conta");
		int id = input.nextInt();
		input.nextLine(); // buffer do int
		System.out.println("Digite o nome do titular");
		String name = input.nextLine();
		System.out.println("Deseja fazer um deposito inicial? (s/n)");
		char questionInitialDeposit = input.nextLine().charAt(0);
		
		Bank acc1 = new Bank(id, name); // instanciar objeto conta do banco
		
		if (questionInitialDeposit == 's' || questionInitialDeposit == 'S' ) {
			System.out.println("Digite o valor do deposito inicial");
			double initialDeposit = input.nextDouble();
			acc1.deposit(initialDeposit);
		}
		
		System.out.println("Dados da conta:");
		System.out.println("Conta " + acc1.getId() + ", Titular " + acc1.getName() + ", Saldo " + acc1.getBalance() + "\n");
		
		
		System.out.println("Digite um valor de deposito:");
		double deposit = input.nextDouble();
		acc1.deposit(deposit);
		System.out.println("Conta " + acc1.getId() + ", Titular " + acc1.getName() + ", Saldo " + acc1.getBalance() + "\n");

		System.out.println("Digite um valor de saque:");
		double withdray = input.nextDouble();
		acc1.withdray(withdray);
		System.out.println("Conta " + acc1.getId() + ", Titular " + acc1.getName() + ", Saldo " + acc1.getBalance());
    
	}
}
