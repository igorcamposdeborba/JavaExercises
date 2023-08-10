package principal;

import java.util.function.BinaryOperator;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Principal3 {
	public static void main (String [] args) {
		
		// 3) fatorial: recebe um numero natural e retorna o seu fatorial
		int a = 4;

	// Opção 1:
		long factorial = LongStream.rangeClosed(1, (long) a)
													.reduce(1, (x, y) -> {
														System.out.print( x + "*" + y);
														long result = x * y;
														System.out.println(" = " + result);
														return result;
													});
		
	    System.out.println("\n" + factorial);
	    
	}
}
