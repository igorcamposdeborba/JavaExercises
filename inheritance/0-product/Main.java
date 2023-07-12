package inheritance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
	public static void main (String [] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Mascara para reordenar a data
		
		System.out.println("Digite o numero de produtos");
		int quantityProducts = input.nextInt();
		
		List<Product> productList = new ArrayList<Product>(); // array de produtos
		
		for (int i=0; i<quantityProducts; i++) {
			System.out.print("Dados do produto " + (i+1) + ":");
			System.out.print("\nComum, Usado ou Importado? (Digite: C, U ou I) ");
			char productType = input.next().charAt(0);

			System.out.print("Nome do produto: ");
			input.nextLine(); // buffer do char
			String name = input.nextLine();
			System.out.print("Preco do produto: ");
			double price = input.nextDouble();
			
			if (productType == 'C' || productType == 'c') {
				productList.add(new Product(name, price));
			
			} else if (productType == 'I' || productType == 'i') {
				System.out.println("Digite o imposto sobre produto importado");
				double customFee = input.nextDouble();
				productList.add(new ImportedProduct(name, price, customFee));
				
			} else if (productType == 'U' || productType == 'u') {
				try {
					System.out.print("Digite a data de fabricacao (dd/MM/yyyy): ");
					Date manufacturedDate = sdf.parse(input.next());
					productList.add(new UsedProduct(name, price, manufacturedDate));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("\nEtiquetas de preco:");
		for (Product i : productList) {
			System.out.println(i.priceTag());;
		}

		input.close();
	}
}
