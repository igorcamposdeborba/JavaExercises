package basic;

import java.util.Scanner;

public class ChallengeOperator2 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("O funcionario terminou o trabalho de terca?");
		boolean first = input.nextBoolean();
		System.out.println("O funcionario terminou o trabalho de terca?");
		boolean second = input.nextBoolean();
		
		if (first == true && second == true) {
			System.out.println("Vai comprar TV de 50 polegadas + sorvete");
		} else if (first == true || second == true) {
			System.out.println("Vai comprar TV de 29 polegadas + sorvete");
		} else {
			System.out.println("Nao vai sair");
		}
		
	}
}
