package br.com.coder.app.calculation;

import br.com.coder.app.calculation.internal.ArithmeticOperations;

public class Calculator {
	private ArithmeticOperations opArithmetics = new ArithmeticOperations();
	
	public double sum(double ... nums) { // Por meio deste método, eu acesso no projeto app-financial os métodos de ArithmeticOperations
		return opArithmetics.sum(nums);
	}
}
 