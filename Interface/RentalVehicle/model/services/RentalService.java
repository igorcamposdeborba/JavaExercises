package model.services;

import entities.CarRental;
import entities.Invoice;

public class RentalService {
	private Double pricePerDay;
	private Double pricePerHour;
	private TaxService taxService; // associação da interface TaxService. Baixo acoplamento porque não depende exclusivamente para regras de imposto de um país
	
	public RentalService(Double pricePerDay, Double pricePerHour, TaxService taxService) {
		super();
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.taxService = taxService;
	}
	
	// calcular nota de pagamento do CarRental
	public void processInvoice(CarRental carRental) {
		long t1 = carRental.getStart().getTime(); // data em millisegundos
		long t2 = carRental.getFinish().getTime();
		
		double hours = (double) (t2 - t1) / 1000 / 60 / 60; // converter hora para segundos, depois para / minutos, depois para / horas
		
		double basicPayment;
		if (hours <= 12.0) {
			basicPayment = Math.ceil(hours) * pricePerHour; // calcular preço por hora
		} else {
			basicPayment = Math.ceil(hours / 24) * pricePerDay; // calcular preço por dia
		}
		
		// calcular imposto
		double tax = taxService.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment, tax)); // ASSOCIAR objeto aluguel do carro com o objeto nota de pagamento
	}
}
