package principal;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principal8 {
	public static void main (String [] args) {
		
	// 8) maior: recebe uma lista de números e retorna o maior obs.: não usar a função max
		int [] list = {2, 0, 8, 5, 4, 7, 3};

	// Opção 1:
		Integer max = Arrays.stream(list)
								.reduce(0, (accumulator, elementActual) -> elementActual > accumulator == true ? elementActual : accumulator);
		
		System.out.println("Maior numero do array: " + max);
	    
	}
}
