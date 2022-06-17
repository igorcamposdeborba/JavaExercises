package services;

// insterface declara um contrato em que todas as classes precisam implementar os atributos e métodos dela e definirem o corpo
public interface OnlinePaymentService {
	
	// taxa de juros sobre a quantia
	public double paymentFee (double amount);
	
	// juros simples por mês
	public double interest(double amount, int months);
}
