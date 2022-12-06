package service;

import java.time.Duration;

import entities.CarRental;
import entities.Invoice;

public class RentalService {
	private Double pricePerHour, pricePerDay;
	
	private TaxService taxService; // composição
	
	public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}
	
	public void processInvoice(CarRental carRental) {
		double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
		double hours = minutes / 60.00;
		
		double basicPayment;
		
		if (hours <= 12.00) { // calcular se o preço base vai ser por hora ou dia
			basicPayment = pricePerHour * Math.ceil(hours);
		} else {
			basicPayment = pricePerDay * (Math.ceil(hours / 24));
		}
		
		double tax = taxService.tax(basicPayment); // calcular imposto
		
		carRental.setInvoice(new Invoice(basicPayment, tax)); // Calcular nota fiscal instanciando o objeto nota fiscal.
		
	}
}
