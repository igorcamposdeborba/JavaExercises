package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class Program {
	public static void main (String [] args) throws ParseException {
		/*Uma empresa deseja automatizar o processamento de seus contratos. O processamento de
		um contrato consiste em gerar as parcelas a serem pagas para aquele contrato, com base no
		número de meses desejado.
		
		A empresa utiliza um serviço de pagamento online para realizar o pagamento das parcelas.
		Os serviços de pagamento online tipicamente cobram um juro mensal, bem como uma taxa
		por pagamento. Por enquanto, o serviço contratado pela empresa é o do Paypal, que aplica
		juros simples de 1% a cada parcela, mais uma taxa de pagamento de 2%.
		
		Fazer um programa para ler os dados de um contrato (número do contrato, data do contrato,
		e valor total do contrato). Em seguida, o programa deve ler o número de meses para
		parcelamento do contrato, e daí gerar os registros de parcelas a serem pagas (data e valor),
		sendo a primeira parcela a ser paga um mês após a data do contrato, a segunda parcela dois
		meses após o contrato e assim por diante. Mostrar os dados das parcelas na tela.*/
		
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.println("Digite os dados do contrato");
		System.out.println("Número do contrato:");
		int contractId = input.nextInt();
			input.nextLine();// buffer do int
		System.out.println("Data do contrato (dd/mm/aaaa):");
		Date date = sdf.parse(input.next());
		System.out.println("Valor total do contrato:");
		double contractValue = input.nextDouble();
		System.out.println("Número de parcelas:");
		int contractInstallments = input.nextInt();
			input.nextLine();// buffer do int
			
			
		Contract contract = new Contract(contractId, date, contractValue);
		
		ContractService cs = new ContractService(new PaypalService());
		cs.processContract(contract, contractInstallments);
		
		System.out.println("Parcelas:");
		for (Installment i : contract.getInstallment()) {
			System.out.println(i);
		}
		
		input.close();
	}
}
