package principal;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principal6 {
	public static void main (String [] args) {
		
		// 6) pertence: recebe uma lista e um elemento qualquer e verifica se o elemento pertence à lista ex.: pertence 1 [3,7,4,2] = False
		int [] list = {2, 0, 8, 5, 4, 7, 9};
		int n = 7;

	// Opção 1:
		Boolean containsValue = Arrays.stream(list)
										.anyMatch(number -> number == n);
		
		System.out.println("Contem o valor " + n + "? " + containsValue);
	    
	}
}
