package vectors;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

		/* Fazer um programa para ler um vetor de N números inteiros. Em seguida, mostrar na tela a média 
		aritmética somente dos números pares lidos, com uma casa decimal. Se nenhum número par for 
		digitado, mostrar a mensagem "NENHUM NUMERO PAR"*/
public class EvenAverage {
	public static void main (String [] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		System.out.println("Quantos elementos vai ter o vetor?");
		int dimension = input.nextInt();
	
		int [] elements = new int[dimension];
		int counterEven = 0;
		double resultOddAverage = 0;
		
		for (int i=0; i<dimension; i++) {
			System.out.println("Digite um numero:");
			int inputNumber = input.nextInt();
			elements[i] = inputNumber;
			
			if (inputNumber %2 == 0) {
				counterEven++;
			}
		}
		
		ArrayList <Double> evenArray = new ArrayList<Double>();
			
		// for each para adicionar os pares num array
		for (double i : elements) {
			
			if (i %2 == 0) {
				evenArray.add(i);
			}
		}
	
		if (counterEven > 0) {
			for (double i : evenArray) {
				resultOddAverage += i;
			}
			resultOddAverage = resultOddAverage / counterEven;
			System.out.printf("Media dos pares = %.1f", resultOddAverage);
		} else {
			System.out.println("Nenhum numero par");
		}

	}
}
