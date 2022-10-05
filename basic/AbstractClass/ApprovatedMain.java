package vectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

		/*Fazer um programa para ler um conjunto de N nomes de alunos, bem como as notas que eles tiraram 
		no 1º e 2º semestres. Cada uma dessas informações deve ser armazenada em um vetor. Depois, imprimir 
		os nomes dos alunos aprovados, considerando aprovados aqueles cuja média das notas seja maior ou igual a 6.0 (seis).
		*/
public class ApprovatedMain {

	public static void main (String [] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		System.out.println("Quantas pessoas voce vai digitar?");
		int dimension = input.nextInt();
	
		Approvated [] peopleArray = new Approvated[dimension];
		
		for (int i=0; i<dimension; i++) {
			String tempName; // guardar temporariamente as variáveis do indice do loop atual
			double tempFirstGrade;
			double tempSecondGrade;
			
			System.out.println("Digite o nome da "+ (i+1) + "a pessoa");
			tempName = input.nextLine();
			tempName = input.nextLine(); // buffer do int
			System.out.println("Digite a nota do primeiro semestre");
			tempFirstGrade = input.nextDouble();
			System.out.println("Digite a nota do segundo semestre");
			tempSecondGrade = input.nextDouble();
			
			// criar objeto
			Approvated person = new Approvated(tempName, tempFirstGrade, tempSecondGrade);
			// colocar objeto no array
			peopleArray[i] = person;
		}
		
		ArrayList <String> approvedPersonName = new ArrayList<String>();
		for (int i=0; i<dimension; i++) {
			if (peopleArray[i].average() != null) {
				approvedPersonName.add(peopleArray[i].average());
			}
		}
		
		System.out.println("Alunos aprovados: " + approvedPersonName);
	}
}
