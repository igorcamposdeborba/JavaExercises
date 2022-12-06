package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.CarRental;
import entities.Vehicle;
import service.BrazilTaxService;
import service.RentalService;

public class Principal {
	public static void main (String [] args) {
		Scanner input = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		System.out.println("Digite os dados do aluguel");
		System.out.print("Modelo do carro ");
		String model = input.nextLine();
		System.out.print("Retirada (dd/mm/aaaa hh:mm) ");
		LocalDateTime start = LocalDateTime.parse(input.nextLine(), dtf);
		System.out.print("Retorno (dd/mm/aaaa hh:mm) ");
		LocalDateTime finish = LocalDateTime.parse(input.nextLine(), dtf);
		System.out.print("Preco por hora ");
		double pricePerHour = input.nextDouble();
		System.out.print("Preco por dia ");
		double pricePerDay = input.nextDouble();
		
		CarRental vehicle = new CarRental(start, finish, new Vehicle(model)); // instantiate vehicle
		RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService()); // instantiate price of rental
		
		rentalService.processInvoice(vehicle);
		
		System.out.println("Fatura:");
		System.out.println("Pagamento basico: " + String.format("%.2f", vehicle.getInvoice().getBasicPayment()));
		System.out.println("Imposto: " + String.format("%.2f", vehicle.getInvoice().getTax()));
		System.out.println("Pagamento total: " + String.format("%.2f", vehicle.getInvoice().totalPayment()));
		
		input.close();
	}
}
