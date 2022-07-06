package entities;

import java.security.InvalidParameterException;

public interface InterestService {
	
	public double getInterestRate();
	
	public default double payment(double amount, int months) throws InvalidParameterException { // método default não precisa implementar nas subclasses que implementam a interface
		if (months < 1)
			throw new InvalidParameterException();
		return amount * Math.pow(1.0 + getInterestRate() / 100.0, months);
	}
}
