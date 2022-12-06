package entities;

public class Vehicle {
	private String model;
	
	public Vehicle(String model) {
		this.model = model;
	}
	
	public String getModel() { // O usuário precisa fazer um novo aluguel (CarRental com nova nota fiscal Invoice) para mudar o carro
		return model;
	}
	
}
