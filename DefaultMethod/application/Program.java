package application;

import java.util.Locale;
import java.util.Scanner;

import entities.BrazilInterestService;

public class Program {
	// Fazer um programa para ler uma quantia e a duração em meses de um
	// empréstimo. Informar o valor a ser pago depois de decorrido o prazo do
	// empréstimo, conforme regras de juros do Brasil. A regra de cálculo de
	// juros do Brasil é juro composto padrão de 2% ao mês.
	
	public static void main (String [] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		System.out.println("Amount:");
		double amount = input.nextDouble();
		System.out.println("Months:");
		int months = input.nextInt();
		
		BrazilInterestService interest = new BrazilInterestService(2.0);
		double payment = interest.payment(amount, months);
		
		System.out.println("Payment after " + months + " months:");
		System.out.println(String.format("%.2f", payment));
		
		input.close();
	}
	
}
