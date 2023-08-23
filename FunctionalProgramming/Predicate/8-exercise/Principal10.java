package principal;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Principal10 {
	public static void main (String [] args) {
		
	/* 10) unica-ocorrencia: recebe um elemento e uma lista e verifica
		se existe uma única ocorrência do elemento na lista
		ex.:
		unica-ocorrencia 2 [1,2,3,2] = False
		unica-ocorrencia 2 [3,1] = False
		unica-ocorrencia 2 [2] = True */
		
		int [] list = {2, 0, 2, 5, 4, 7, 4, 5, 4};
		int n = 1;
		
	// Opção 1:
		Predicate<Object> countOccurrences = number -> Objects.equals(number, n);
		
		int singleOccurrences = (int) IntStream.of(list)
						                .filter(number -> number == n)
						                .count();
		boolean isDuplicated = singleOccurrences > 1 ? true : false;
		
		System.out.println("Ha duplicacao do numero " + n + "? " + isDuplicated);
	    
	}
}
