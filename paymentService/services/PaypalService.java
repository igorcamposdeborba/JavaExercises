package services;

// implements interface
public class PaypalService implements OnlinePaymentService {
	private static final double PAYMENT_FEE = 0.02;
	private static final double MONTHLY_INTEREST = 0.01;
	
	// taxa de juros sobre a quantia
	@Override
	public double paymentFee(double amount) {
		return amount * PAYMENT_FEE; // porcentagem: obter 2% desta parcela
	}
	
	// juros simples mensal
	@Override
	public double interest(double amount, int months) {
		return amount * months * MONTHLY_INTEREST; // porcentagem: obter 1% sobre o total de meses
	}
}
