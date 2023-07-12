package principal;

import java.util.Scanner;

import entities.Animal;
import entities.Dog;
import entities.Veterinary;
import entities.Whale;
import entities.enums.Size;

public class Main {
	public static void main(String [] args) {
		
		// Variáveis
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o nome do cachorro");
		String nameAnimal1 = input.nextLine();
		
		System.out.println("Digite o nome do veterinario");
		String nameVeterinary1 = input.nextLine();
		
		System.out.println("Digite o nome da baleia");
		String nameAnimal2 = input.nextLine();
		
		int idAnimal1 = (int) Math.random() * 100 + 1; // gerar id. Fazer casting (int) porque é uma classe Math 
												   // e preciso dizer que quero um tipo de dado primitivo int
		int idAnimal2 = (int) Math.random() * 100 + 1; 
												   // random() gera número entre zero (0) e um (1). Exemplo: 0.3
		   										   // Por isso multipliquei por 100.
		
		// Instanciar objetos
		Veterinary veterinary1 = new Veterinary(nameVeterinary1); // Lembre-se: instancie primeiro as pequenas partes, depois o todo
		Animal dog1 = new Dog(idAnimal1, nameAnimal1, veterinary1);
		
		
		Animal whale1 = new Whale(idAnimal2, nameAnimal2, Size.MEDIUM); // enum: é público, então dá pra chamar direto
		
		
		// Mostrar em tela
		System.out.println(dog1.toString());
		System.out.println(whale1.toString());
		
		
	}	
}
