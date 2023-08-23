package principal;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Principal12 {
	public static void main (String [] args) {
		
	// 12) concatena: recebe duas listas quaisquer e retorna uma terceira lista com os elementos da primeira no início e os elementos da segunda no fim
		
		int [] list1 = {2, 0, 2, 5};
		int [] list2 = {4, 7, 4, 5, 4};
		
	// Opção 1:
		int [] concanated1 = IntStream.concat(Arrays.stream(list1), 
													  Arrays.stream(list2))
													    .toArray();
		
		List <Integer> concanated2 = IntStream.concat(Arrays.stream(list1),
													  Arrays.stream(list2))
													  	.boxed()
													  	.collect(Collectors.toList());
		
		// Opção 1 de print (com intStream)
		IntStream.of(concanated1)
					.forEach(i -> System.out.print(i + ", "));
		
		System.out.println();
		
		// Opção 2 de print (com Stream.Bulder)
		Stream.Builder<Integer> streamBuilder = Stream.builder(); // criar uma stream para guardar os valores
		for(int i : concanated1) {
			streamBuilder.accept(i);
		}
		
		Stream<Integer> integerStream = streamBuilder.build(); // criar uma stream para printar
		integerStream.forEach(i -> System.out.print(i + ", "));
		
		System.out.println();
		
		// Opção 3 de print
		for(Integer i : concanated1) {
			System.out.print(i + ", ");
		}

		System.out.println("\n" + concanated2);
	    
	}
}
