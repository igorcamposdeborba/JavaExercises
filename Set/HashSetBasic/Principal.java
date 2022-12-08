package hashSetBasic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Principal {
	public static void main (String [] args) {
		
		
		Scanner input = new Scanner(System.in);
		
		Set <Integer> class1 = new HashSet<Integer>(); // HashSet não aceita repetições e é desordenado
		Set <Integer> class2 = new HashSet<>();
		Set <Integer> class3 = new HashSet<Integer>();
		
		Set <Integer> totalStudents = new HashSet<>();
		
		
		System.out.println("Quantos estudantes existem no curso 1?");
		int q1 = input.nextInt();

		for (int i=0; i < q1; i++) {
			System.out.println("Digite o " + (i+1) + "o valor");
			class1.add(input.nextInt()); // add into HashSet
		}
		
		
		System.out.println("Quantos estudantes existem no curso 2?");
		int q2 = input.nextInt();

		for (int i=0; i < q2; i++) {
			System.out.println("Digite o " + (i+1) + "o valor");
			class2.add(input.nextInt());
		}
		
		
		System.out.println("Quantos estudantes existem no curso 3?");
		int q3 = input.nextInt();
		
		for (int i=0; i < q3; i++) {
			System.out.println("Digite o " + (i+1) + "o valor");
			class3.add(input.nextInt());
		}
		
		totalStudents.addAll(class1);
		totalStudents.addAll(class2);
		totalStudents.addAll(class3);
		
		System.out.println("Alunos unicos: " + totalStudents.size());
		System.out.println("Soma de matriculas nas disciplinas: " + class1.size() + class2.size() + class3.size());
		
		
		input.close();
	}
}
