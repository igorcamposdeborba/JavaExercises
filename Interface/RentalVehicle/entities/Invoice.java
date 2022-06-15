package entities;

public class Invoice {
	private Double basicPayment; // classe wrappper tipo Double para aceitar null na possível integração com o banco de dados
	private Double tax;
	
	public Invoice(Double basicPayment, Double tax) {
		this.basicPayment = basicPayment;
		this.tax = tax;
	}
	
	public Double getBasicPayment() {
		return basicPayment;
	}
	public Double getTax() {
		return tax;
	}
	
	public void setBasicPaument(Double basicPayment) {
		this.basicPayment = basicPayment;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}
	
	public Double getTotalPayment() {
		return basicPayment + tax;
	}
}
