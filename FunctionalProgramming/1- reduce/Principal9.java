package principal;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principal9 {
	public static void main (String [] args) {
		
	// 8) conta-ocorrencias: recebe um elemento e uma lista qualquer, retorna o número de ocorrências do elemento na lista
		int [] list = {2, 0, 4, 5, 4, 7, 4, 5, 9};
		int n = 2;
		
	// Opção 1:
		Integer countOccurrences = Arrays.stream(list)
								.filter(number -> number == n)
								.reduce(0, (accumulator, elementActual) -> elementActual == n == true ? accumulator + 1 : accumulator);
    
		// Opção 2:
				Integer countOccurrences2 = (int) Arrays.stream(list)
										.filter(number -> number == n)
										.count();
				
		System.out.println("Maior numero do array: " + countOccurrences);
		System.out.println("Maior numero do array: " + countOccurrences2);
	    
	}
}
