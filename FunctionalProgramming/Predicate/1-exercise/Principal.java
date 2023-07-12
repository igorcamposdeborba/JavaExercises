package funcional2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Principal {
	public static void main (String [] args) {
		
		List<Person> personList = new ArrayList<>();
		
		personList.add(new Person("Natanael", 20));
		personList.add(new Person("John", 40));
		personList.add(new Person("Lana", 30));		
		personList.add(new Person("Ana", 15));
		personList.add(new Person("Carla John", 60));
		
		
		// MAP ACEITA CORPO: Exemplo útil para mostrar que o map aceita um corpo e retorna algo
		/*List<Person> personStream = personList.stream()
										  .map(person -> { 
											  String nameLowerCase = person.getName().toLowerCase(); // Converter para minúsucula (mas modificando o array original, que não é recomendado)
											  person.setName(nameLowerCase);
											  return person;
										  })
										  .collect(Collectors.toList());*/
		
		// CONSULTAS: dividir em operações menores por meio de Interfaces Funcionais
		Predicate<Person> nameLessFiveCharacters = (Person person) -> person.getName().length() < 5; // Predicate: bom para consultas na stream
		Predicate<Person> findBySmallName = (Person name) -> name.getName().toLowerCase().contains("ANA".toLowerCase()); // declarar Tipo do index
		Predicate<Person> findByAge = (Person age) -> { return age.getAge() > 11; }; // outra forma de retornar o corpo
		Comparator<Person> compareAge = Comparator.comparing(Person::getAge); // comparar idades para ordenar pelo sorted(compareAge)
		
		
		// APLICAR na Stream
		List<Person> personStream = personList.stream().filter(nameLessFiveCharacters)
													   .filter(findBySmallName)
													   .filter(findByAge)
													   .sorted(compareAge)
													   //.sorted() // também posso fazer assim
													   .collect(Collectors.toList());
		
		// NÃO RECOMENDADO: Todas operações juntas (não recomendado porque fere o princípio de Função de primeira classe da programação funcional 
		// porque não é possível reaproveitar o código por estar dentro de uma stream específica)
		List<Person> personDontRecomended = personList.stream().filter((Person person) -> person.getName().length() < 5)
															   .filter((Person name) -> name.getName().toLowerCase().contains("ANA".toLowerCase()))
															   .filter((Person age) -> age.getAge() > 11)
															   .collect(Collectors.toList());
		
		
		personStream.stream().forEach(System.out::println);
		System.out.println();
		personDontRecomended.stream().forEach(System.out::println);
		
		
		
		
	}
}
