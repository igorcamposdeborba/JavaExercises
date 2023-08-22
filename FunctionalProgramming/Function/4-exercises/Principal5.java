package principal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principal5 {
	public static void main (String [] args) {
		
		// 5) elemento: recebe uma lista e um número inteiro positivo para retornar o n-ésimo elemento da lista ex.: (elemento 1 '(3 7 4 2)) ==> 3
		int [] list = {2, 0, 8, 5, 4, 7, 9};
		int n = 6;

	// Opção 1:
		List<Integer> result = Stream.of(list)
							.map(number -> list[n])
							.collect(Collectors.toList());
		
		int [] convertedResult = new int[result.size()];
		for (int i=0; i<result.size(); i++) {
			convertedResult[i] = result.get(i).intValue(); // converter de Integer para int
		}
		
	// Opção 2:
		int[] result2 = List.of(list).stream()
							.limit(n + 1)				
							.mapToInt(i -> list[n])
							.toArray();
	
	    System.out.println(Arrays.toString(convertedResult));
	    System.out.println(Arrays.toString(result2));
	    
	}
}
