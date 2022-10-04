package vectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/*Fazer um programa para ler um número inteiro N e depois um vetor de N números reais. Em seguida, 
	mostrar na tela a média aritmética de todos elementos com três casas decimais. Depois mostrar todos 
	os elementos do vetor que estejam abaixo da média, com uma casa decimal cada. */
public class UnderAverage {
	public static void main (String [] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		System.out.println("Quantos elementos vai ter o vetor?");
		int dimension = input.nextInt();
		
		double [] elements = new double[dimension];
		double accumulate = 0;
		int counterPositive = 0;
		double counterUnderAverage = 0;
		
		for (int i=0; i<dimension; i++) {
			System.out.println("Digite um numero:");
			double positive = input.nextDouble();
			
			if (positive > 0) {
				elements[i] = positive;
				accumulate = accumulate + positive;
				counterPositive++;
			}
		}
		
		double average = accumulate / counterPositive;
		ArrayList<Double> underAverage = new ArrayList<Double>();
		
		// passar pelo array para salvar os numeros abaixo da media
		for (int i=0; i<dimension; i++) {
			if (elements[i] < average) {
				underAverage.add(elements[i]);
			}
		}
		
		System.out.printf("%nMedia do array: %.3f%n", average);
		System.out.println("Elementos abaixo da media:");
		System.out.println(underAverage);
	
	}
}
