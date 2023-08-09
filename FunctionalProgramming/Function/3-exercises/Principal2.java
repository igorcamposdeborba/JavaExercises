package principal;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

public class Principal2 {
	public static void main (String [] args) {
		
		// 2) menorDeTres: recebe três valores e retorna o menor
		double a = 12.1;
	    double b = 13.0;
	    double c = 13.0;
	
	// Opção 1:
	    Double compared = Stream.of(a, b, c)
						                .reduce((x, y) -> x >= y ? y : x)
						                .orElse(Double.NaN);
	    System.out.println(compared);
	    
	// Opção 2:
	    System.out.println(compareElements(a, b, c));
	    
	// Opção 3:
		Double compare = Stream.of(a, b, c)
				.reduce(Double::min) // reference method
				.get();
		System.out.println(compare);
	   
	}
    public static double compareElements(double a, double b, double c) {
    	BinaryOperator<Double> compareElements = (x, y) -> x >= y == true ? y : x;
    	
    	return compareElements.apply(a, compareElements.apply(b, c));
    }
}
