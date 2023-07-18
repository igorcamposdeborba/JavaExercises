package principal;

import entities.Animal;
import entities.Cat;

public class Principal {
	public static void main(String [] args) {
		
		Animal animal1 = new Animal();
		Animal cat1 = new Cat();
		Cat cat2 = new Cat();
		
		animal1.makeSound();
		cat1.makeSound();
		// cat1.moviment();
		Cat cat3 = (Cat)cat1;
		cat3.moviment();
		
		cat2.makeSound();
	}
}
