package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Contract {
	// número do contrato, data do contrato, e valor total do contrato).
	private int id;
	private LocalDate date;
	private double totalValue;
	
	private List<Installment> installment = new ArrayList<Installment>(); // composição
	
	public Contract (int id, LocalDate date, double totalValue) {
		this.id = id;
		this.date = date;
		this.totalValue = totalValue;
	}
	
	public int getId() {
		return id;
	}
	public LocalDate getDate() {
		return date;
	}
	public double getTotalValue() {
		return totalValue;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	
	
	public List <Installment> getInstallment() {
		return installment;
	}

}
