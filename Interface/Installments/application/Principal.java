package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class Principal {
/* Entity: guarda os dados de: 
 * 			1) contrato 
 * 			2) parcelamento
 * Service: calcula: 
 * 			1) as parcelas do contrato 
 * 			2) os juros
 */
	
	public static void main (String [] args) {
		
		Scanner input = new Scanner(System.in);
		DateTimeFormatter  dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Digite os dados do contrato");
		System.out.print("Numero: ");
		int idContract = input.nextInt();
		input.nextLine(); // buffer do int
		System.out.print("Data (dd/mm/aaaa): ");
		LocalDate dueDate = LocalDate.parse(input.nextLine(), dtf);
		System.out.print("Valor do contrato: ");
		double totalAmount = input.nextDouble();
		System.out.print("Digite o numero de parcelas: ");
		int installments = input.nextInt();
		
		Contract contract = new Contract(idContract, dueDate, totalAmount); // instanciar contrato
		ContractService contractService = new ContractService(new PaypalService());
		
		contractService.processContract(contract, installments);
		
		System.out.println("Parcelas");
		 for (Installment i : contract.getInstallment()) {
			 System.out.println(i);
		 }
		
	}
}
