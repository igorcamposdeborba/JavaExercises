package entities;

public class Invoice {
	
	private Double basicPayment;
	private Double tax;
	
	public Invoice(Double basicPayment, Double tax) {
		this.basicPayment = basicPayment;
		this.tax = tax;
	}
	
	public Double getBasicPayment() { // O usuario não pode alterar o pagamento base definido no momento do aluguel. Por isso não tem set
		return basicPayment;
	}
	public Double getTax() { // O usuario não pode alterar o imposto definido no momento do aluguel. Por isso não tem set
		return tax;
	}
	
	
	public Double totalPayment() {
		return getBasicPayment() + getTax();
	}
}
