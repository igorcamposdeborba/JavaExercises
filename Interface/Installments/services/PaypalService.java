package services;

public class PaypalService implements PaymentService {
	
	private static final double FEE_PERCENTAGE = 0.02;
	private static final double MONTHLY_PERCENTAGE = 0.01;
	
	public PaypalService () {}
	
	@Override
	public double paymentFee(double amount) {
		return amount * FEE_PERCENTAGE;
	}
	
	@Override
	public double interest(double amount, int months) {
		return amount * MONTHLY_PERCENTAGE * months;
	}
}
