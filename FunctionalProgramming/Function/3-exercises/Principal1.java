package principal;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class Principal1 {
	public static void main (String [] args) {
		
		// 1) menorDeDois: recebe dois valores e retorna o menor
		double a = 12.1;
	    double b = 13.0;
	    
	    
	// Opção 1:
		Function<Double, Double> compareElements = x -> x >= b == true ? b : x;
		
		Optional<Double> smallestElement = Stream.of(a)
													.map(compareElements)
													.findFirst();
		
		smallestElement.ifPresent(System.out::println);
		
	// Opção 2:
		Double comparedElements = Stream.of(a, b)
											.reduce((x, y) -> x >= y == true ? y : x)
											.orElse(Double.NaN);
		System.out.println(comparedElements);
		
	// Opção 3:
		Double compare = Stream.of(a, b)
									.reduce(Double::min) // reference method
									.get();
		System.out.println(compare);
	}
}
