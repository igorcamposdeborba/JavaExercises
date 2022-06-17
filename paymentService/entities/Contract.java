package entities;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Contract {
	private Integer number;
	private Date date; // composição
	private Double totalValue;
	
	// Associação: Contract conhece as parcelas Installments associadas a ele
	// por meio e uma Lista do tipo da outra classe
	List<Installment> installments = new ArrayList<Installment>();
	
	public Contract () {}
	
	// polimorfismo (diferentes argumentos para o mesmo construtor/método)
	public Contract (Integer number, Date date, Double totalValue) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}
	
	public Integer getNumber() {
		return number;
	}
	public Date getDate() {
		return date;
	}
	public Double getTotalValue() {
		return totalValue;
	}
	
	// Não criar método set para Lista porque senão o método trocaria a Lista
	public List<Installment> getInstallment(){
		return installments;
	}

	
	public void setNumber(Integer number) {
		this.number = number;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	
	
}
