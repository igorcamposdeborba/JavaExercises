import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Products;

public class Principal {
	/*Fazer um programa para ler um conjunto de produtos a partir de um
	arquivo em formato .csv (suponha que exista pelo menos um produto).
	Em seguida mostrar o preço médio dos produtos. Depois, mostrar os
	nomes, em ordem decrescente, dos produtos que possuem preço
	inferior ao preço médio.*/
	
	public static void main(String [] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o caminho do arquivo");
		String path = input.nextLine();
		
		List<Products> productList = new ArrayList<Products>();
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
		
			String line = br.readLine(); // ler linha
			
			while (line != null) {
				
				String [] fields = line.split(",");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				
				productList.add(new Products(name, price));
				
				line = br.readLine();
			}
			
			
			// stream
			double priceAverage = productList.stream()
											 .map(p -> p.getPrice()) 							// passar por cada preço
											 .reduce(0.0, (x, y) -> x + y) / productList.size();// somar ao anterior e no final dividir pelo numero de elementos (para fazer a média)

			System.out.println("Preco medio R$ " + String.format("%.2f", priceAverage));
			
			
			Comparator<String> compareProducts = (p1, p2) -> p1.toUpperCase().compareTo(p2.toUpperCase());
			
			List<String> names = productList.stream() 
											.filter(p -> p.getPrice() < priceAverage)
											.map(p -> p.getName()).sorted(compareProducts.reversed())
											.collect(Collectors.toList());
			
			names.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			input.close();
		}
	}
}
