package principal;

import java.util.OptionalInt;
import java.util.function.BinaryOperator;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Principal4 {
	public static void main (String [] args) {
		
		// 4) fibonacci: recebe um número inteiro positivo e retorna o n-ésimo elemento da seqüência de Fibonacci (especificar no programa se sua
		// seqüência começa com 0 e 1 ou com 1 e 1)
		int n = 7;

	// Opção 1:
		
	    System.out.println(fibonacci(n));
	    
	}
	
	public static int fibonacci(int n) {
		return Stream.iterate(new int[]{0, 1}, fib -> new int[] {fib[1], fib[0] + fib[1] })
													.limit(n)
													.mapToInt(fib -> fib[0])
													.max()
													.orElse(0);
	}
}
