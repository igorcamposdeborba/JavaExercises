package principal;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Principal11 {
	public static void main (String [] args) {
		
	// 11) maiores-que: recebe um número e uma lista de números, retorna uma lista com os números que são maiores que o fornecido
		
		int [] list = {2, 0, 2, 5, 4, 7, 4, 5, 4};
		int n = 4;
		
	// Opção 1:
		List<Integer> greatherThan = Arrays.stream(list)
						                .filter(number -> number > n)
						                .boxed() // converter de int para Integer
						                .distinct()
						                .collect(Collectors.toList());
		
		System.out.println("Numeros maiores que  " + n + ": " + greatherThan);
	    
	}
}
