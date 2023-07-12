package funcional4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import funcional4.Person;

public class Principal {
	public static void main (String [] args) {
		
		// Variáveis
		List<Person> personList = new ArrayList<>();
		personList.add(new Person("Natanael", 20));
		personList.add(new Person("John", 40));
		personList.add(new Person("Ana", 30));		
		personList.add(new Person("Ana", 15));
		personList.add(new Person("Carla John", 60));
		
		personList.stream().forEach(System.out::println); // operação terminal forEach com method reference
		
		
		// Interfaces funcionais para processamento
		Function<Person, String> getByName = Person::getName;
		Function<Person, Integer> getByAge = Person::getAge;
		
		Comparator<Person> compareNameAndAge = Comparator.comparing(getByName).thenComparing(getByAge); // ORDENAR por nome e depois por idade se os nomes forem iguais
		
		
		System.out.println("\nAlfabetico:");
		
		// Stream para aplicar processamento
		personList.stream().sorted(compareNameAndAge)
						   .forEach(System.out::println);
		
	}
}
