package basic;

import java.util.Scanner;

public class ChallengeCalculation {
	public static void main (String [] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite um numero");
		double x = input.nextDouble();
		System.out.println("Digite um outro numero");
		double y = input.nextDouble();
		
		System.out.println("Digite uma das seguintes operacoes: + - * / %");
		String op = input.next();
		double result;
		result = "+".equals(op) ? x + y : 0;
		result = "-".equals(op) ? x - y : result;
		result = "*".equals(op) ? x * y : result;
		result = "/".equals(op) ? x / y : result;
		result = "%".equals(op) ? x % y : result;
		
		System.out.println(result);
	
		input.close();
	}
}
