package vectors;

import java.util.Locale;
import java.util.Scanner;

/*Tem-se um conjunto de dados contendo a altura e o gênero (M, F) de N pessoas. Fazer um programa 
	que calcule e escreva a maior e a menor altura do grupo, a média de altura das mulheres, e o número 
	de homens. 
	*/
public class PersonalDataMain {
	public static void main (String [] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		System.out.println("Quantas pessoas voce vai digitar?");
		int dimension = input.nextInt();
	
		PersonalDataStore peopleArray = null; // declare array to save all person here
		PersonalData [] people = new PersonalData[dimension];
		
		for (int i=0; i<dimension; i++) {
			double tempHeight; // save temporarily the variables of actual loop
			char tempGenre; 
			
			System.out.println("Digite a altura da "+ (i+1) + "a pessoa");
			tempHeight = input.nextDouble();
			System.out.println("Digite o genero (M ou F)");
			tempGenre = input.next().charAt(0);
			
			// create object
			PersonalData person = new PersonalData(tempHeight, tempGenre);
			// add object in array
			// peopleArray = new PersonalDataStore(person); // instantiate person inner class with array
			people[i] = person;
		}
		
		peopleArray = new PersonalDataStore(people);
		
		System.out.println("Maior altura: " + peopleArray.greathestHeight());
		System.out.println("Menor altura: " + peopleArray.lowerHeight());
		System.out.println("Media das alturas das mulheres: " + peopleArray.averageHeightWomans());
		System.out.println("Numero de homens: " + peopleArray.quantityMen());
		
		input.close();
	}
}
