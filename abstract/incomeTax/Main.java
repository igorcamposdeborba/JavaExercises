package abstractIncomeTax;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
	public static void main (String [] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite o numero total de pagadores de impostos");
		int payerQuantity = input.nextInt();
		
		List<TaxPayer> payerList = new ArrayList<TaxPayer>(); // list of tax payers
		
		for (int i=0; i<payerQuantity; i++) {
			
			System.out.println("Informacoes do " + (i+1) + "o pagador");
			System.out.print("Pessoa fisica ou juridica? (F/J) ");
			char typeTaxPayer = input.next().charAt(0);
			System.out.print("Nome: ");
			input.nextLine(); // buffer of char
			String name = input.nextLine();
			System.out.print("Renda anual: ");
			double income = input.nextDouble();
			
			if (typeTaxPayer == 'F') {
				System.out.print("Despesas de saude: ");
				double healthExpends = input.nextDouble();
				
				payerList.add(new Personal(name, income, healthExpends)); // instantiate subclass of ABSTRACT superclass
				
				
			} else if (typeTaxPayer == 'J') {
				System.out.print("Quantidade de colaboradores: ");
				int associates = input.nextInt();
				
				payerList.add(new Company(name, income, associates));
			}
		}
		
		double totalTaxPaid = 0.0;
		
		System.out.println("\nImpostos pagos");
		for (TaxPayer i : payerList) {
			
			double incomeTax = i.incomeTax();
			System.out.println(i.getName() + ": R$ " + String.format("%.2f", incomeTax));
			totalTaxPaid += incomeTax;
		}
		
		System.out.println("\nTotal de imposto pago: R$ " + String.format("%.2f", totalTaxPaid));
		
		input.close();
	}
}
