package vectors;

import java.util.Locale;
import java.util.Scanner;

public class Height {
	public static void main (String [] args) {
		/*Fazer um programa para ler nome, idade e altura de N pessoas, conforme exemplo. Depois, mostrar na 
		tela a altura média das pessoas, e mostrar também a porcentagem de pessoas com menos de 16 anos, 
		bem como os nomes dessas pessoas caso houver. 
		 */
		
		// Passo 1: colocar as pessoas cadastradas num array de objetos
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		System.out.println("Quantas pessoas voce vai cadastrar?");
		int dimension = input.nextInt();

		HeightPerson [] peopleArray = new HeightPerson[dimension];
		
		for (int i=0; i<dimension; i++) {
			String tempName; // guardar temporariamente as variáveis do indice do loop atual
			int tempAge;
			double tempHeight;
			
			System.out.println("Digite o nome da "+ (i+1) + "a pessoa");
			tempName = input.nextLine();
			tempName = input.nextLine(); // buffer do int
			System.out.println("Digite a idade");
			tempAge = input.nextInt();
			System.out.println("Digite a altura");
			tempHeight = input.nextDouble();
			
			// criar objeto
			HeightPerson person = new HeightPerson(tempName, tempAge, tempHeight);
			// colocar objeto no array
			peopleArray[i] = person;
		}
		
		// imprimir dados
		for (int i=0; i<dimension; i++) {
			System.out.println("\nDados da "+ (i+1) + "a pessoa:\n"
								+"Nome: "+ peopleArray[i].getName() 
								+ "\nIdade: " + peopleArray[i].getAge() 
								+ "\nAltura: " + peopleArray[i].getHeight()
								+ "\n____________");	
		}
		
		calculatePerson calculate = new calculatePerson(peopleArray);
		
		System.out.printf("Altura media: %.2f%n" , calculate.averageHeight());
		System.out.printf("Porcentagem de pessoas com menos de 16 anos: %.1f%%\n", calculate.averageAgeSixteen());
		System.out.println("Nome das Pessoas com menos de 16 anos: " + calculate.getNameLessThanAgeSixteen());
		
	}
}
