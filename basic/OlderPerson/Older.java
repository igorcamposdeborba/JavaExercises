package vectors;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/*Fazer um programa para ler um conjunto de nomes de pessoas e suas respectivas idades. Os nomes 
	devem ser armazenados em um vetor, e as idades em um outro vetor. Depois, mostrar na tela o nome 
	da pessoa mais velha. 
	*/
public class Older {

	public static void main (String [] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		System.out.println("Quantas pessoas voce vai digitar?");
		int dimension = input.nextInt();
	
		
		OlderPerson [] peopleArray = new OlderPerson[dimension];
		
		
		for (int i=0; i<dimension; i++) {
			String tempName; // guardar temporariamente as variáveis do indice do loop atual
			int tempAge;
			double tempHeight;
			
			System.out.println("Digite o nome da "+ (i+1) + "a pessoa");
			tempName = input.nextLine();
			tempName = input.nextLine(); // buffer do int
			System.out.println("Digite a idade");
			tempAge = input.nextInt();
			
			// criar objeto
			OlderPerson person = new OlderPerson(tempName, tempAge);
			// colocar objeto no array
			peopleArray[i] = person;
		}
		
		int olderPersonAge = 0;
		int positionOlder = 0;
		for (int i=0; i<dimension; i++) {
			if (peopleArray[i].getAge() > olderPersonAge) {
				olderPersonAge = peopleArray[i].getAge();
				positionOlder = i;
			}
		}
		
		System.out.println("Pessoa mais velha: " + peopleArray[positionOlder].getName());
	}
}
