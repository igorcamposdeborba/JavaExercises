package br.com.coder.app.financial;

import br.com.coder.app.calculation.Calculator;

public class Test {
	public static void main (String [] args) {
		
		Calculator calc = new Calculator();
		
		System.out.println(calc.sum(2, 3, 4));
	
	}
}
