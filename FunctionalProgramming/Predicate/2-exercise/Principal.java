package funcional5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Principal {
	public static void main (String [] args) {
		
		ArrayList<Dog> animalList = new ArrayList<>();
		animalList.add(new Dog("Rex", true));
		animalList.add(new Dog("Flora", false));
		animalList.add(new Dog("Bidu", true));
		animalList.add(new Dog("Tom", false));
		
		// Objetivo: Retorne o primeiro elemento da lista:
		
// PROGRAMAÇÃO FUNCIONAL
		// Processamento da lógica
		Predicate<Dog> isVacinated = (Dog dog) -> dog.getVacinated() == true;
		
		// Stream
		List<Dog> vacinatedList = animalList.stream()
													.filter(isVacinated)
													.findFirst()
													.map(Collections::singletonList)
													.orElse(Collections.emptyList());
		
		System.out.println("Programacao Funcional");
		vacinatedList.stream().forEach(System.out::println);
		System.out.println(vacinatedList);
		

		
		System.out.println("____________\nProgramacao Orientada a Objetos");

// ORIENTAÇÃO A OBJETOS			
		System.out.println(getFirstDog(animalList));
				
	}
	public static Dog getFirstDog(ArrayList<Dog> animalList) {
		
		for(Dog dog : animalList) {
			if(dog.getVacinated() == true) {
				return dog;
			}
		}
		return null;
	}
}
