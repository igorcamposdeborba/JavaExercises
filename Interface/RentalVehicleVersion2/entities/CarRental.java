package entities;

import java.time.LocalDateTime;

public class CarRental {

	private LocalDateTime start;
	private LocalDateTime finish;
	
	private Vehicle vehicle; // composição: aluguel de carro TEM UM carro
	private Invoice invoice; // composição: aluguel de carro TEM UMA ou mais notas fiscais
	
	
	public CarRental (LocalDateTime start, LocalDateTime finish, Vehicle vehicle) {
		this.start = start;
		this.finish = finish;
		this.vehicle = vehicle;
	}
	
	public LocalDateTime getStart() {
		return start;
	}
	public LocalDateTime getFinish() {
		return finish;
	}
	public void setFinish(LocalDateTime finish) { 	// O usuário não pode alterar a data de inicio de um aluguel, só pode estender a data de fim
		this.finish = finish;
	}
	
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
}
