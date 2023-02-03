package br.com.coder.app.calculation.internal;

import java.util.Arrays;

public class ArithmeticOperations {
	
	public double sum(double ... nums) {
		return Arrays.stream(nums).reduce(0.0, (t, a) -> t + a);
	}
}
