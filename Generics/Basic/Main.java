package application;

import java.util.Locale;
import java.util.Scanner;

import services.PrintService;

public class Main {
	/* Exercício generics:
	Deseja-se fazer um programa que leia uma quantidade N, e depois N números
	inteiros. Ao final, imprima esses números de forma organizada conforme
	exemplo. Em seguida, informar qual foi o primeiro valor informado*/
	
	public static void main (String [] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		System.out.println("Quantos valores serao cadastrados?");
		int dimension = input.nextInt();
		
		PrintService<Integer> valuesArray = new PrintService<Integer>(); // instanciar valores do array do tipo Integer da classe do tipo generics
		
		for (int i=0; i<dimension; i++) {
			System.out.println("Digite um numero");
			valuesArray.addValue(input.nextInt());
		}
		
		valuesArray.print();
		System.out.println("Primeiro valor: " + valuesArray.first());
		
		input.close();
	}
}
