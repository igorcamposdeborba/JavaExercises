package vectors;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Even {
	/*Faça um programa que leia N números inteiros e armazene-os em um vetor. Em seguida, mostre na 
	tela todos os números pares, e também a quantidade de números pares. 
	*/
	public static void main (String [] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		System.out.println("Quantos numeros voce vai digitar?");
		int dimension = input.nextInt();
		
		// Criar um array maior que o necessario temporariamente para guardar os valores do numeros pares
		Integer [] tempEven = new Integer[dimension];
		int counterEven = 0;
		
		for (int i=0; i<dimension; i++) { // guardar no array temporario os valores pares
			System.out.println("Digite um numero");
			int inputNumber = input.nextInt();
			
			if (inputNumber % 2 == 0) {
				tempEven[i] = inputNumber;
				counterEven++;
			}
		}
	
		// copiar para o tamanho certo o array
		int [] even = new int[counterEven];
		for (int i=0; i<dimension; i++) {
			int counter = 0;
			if (tempEven[i] != null) {
				even[counter] = tempEven[i];
				counter++;
			}
		}
		
		
		System.out.println("Numeros pares: " + Arrays.toString(even));
		System.out.println("Quantidade de pares: " + counterEven);
		
	}
}
