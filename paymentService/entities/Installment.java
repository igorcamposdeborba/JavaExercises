package entities;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment {
	private Date dueDate;
	private Double amount;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Installment() {}
	
	// polimorfismo para diferentes argumentos para o mesmo método/construtor
	public Installment(Date dueDate, Double amount) {
		this.dueDate = dueDate;
		this.amount = amount;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	public Double getAmount() {
		return amount;
	}
	
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	

	
	@Override
	public String toString() {
		return sdf.format(dueDate) + " - " + String.format("%.2f", amount);
	}
}
