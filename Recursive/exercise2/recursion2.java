package recursao;

import java.util.Scanner;

public class recursion2 {
/* Escreva uma método recursivo power(base, exponent) que, quando chamado, retorna
base ^ exponente

Por exemplo, power(3,4) = 3 * 3 * 3 * 3. Assuma que exponent é um inteiro maior ou igual a 1. Dica: o passo de recursão deve adotar o relacionamento
base exponente = base · base exponente – 1
e a condição de terminação se manifesta quando exponent é igual a 1 porque
base1 = base
Incorpore esse método em um programa que permita que o usuário insira a base e o exponent.
}
 */
	public static void main (String [] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite um numero de base");
		int base = input.nextInt();
		input.nextLine();
		System.out.println("Digite um numero para o expoente");
		int exponent = input.nextInt();
		
		System.out.println(power(base, exponent));;
	}
	
	
	static int power(int base, int exponent) {
		if (exponent == 1) { 
			return base; // caso base
		}
		
		return base * power(base, exponent - 1); // decrementar expoente até chegar em 1
		
	}
}
