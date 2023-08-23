package principal;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Principal13 {
	public static void main (String [] args) {
		
	// 12) remover: recebe um elemento e uma lista e retorna a lista sem a primeira ocorrência do elemento
		
		int [] list1 = {2, 0, 2, 5, 4, 7, 4, 5, 4};
		int n = 5;
		
	// Opção 1:
		List<Integer> removedElement = Arrays.stream(list1)
												.filter(item -> item != n)
												.boxed()
												.collect(Collectors.toList());
						
		System.out.println(removedElement);
	    
	}
}
