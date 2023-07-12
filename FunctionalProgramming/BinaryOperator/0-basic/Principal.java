package funcional3;

import java.util.function.BinaryOperator;

public class Principal {
	public static void main (String [] args) {
		
		
		BinaryOperator<Double> pow = Math::pow; // usando method reference (referência ao método) ao invés de usar lambda
		// BinaryOperator<Double> pow = (Double x, Double y) -> Math.pow(x, y); // OU usar lambda expression
		
		Double powSquare = pow.apply(3.0, 2.0);
		
		System.out.println(powSquare);
	}
}
