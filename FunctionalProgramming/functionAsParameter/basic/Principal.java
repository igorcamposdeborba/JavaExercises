import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import entities.Product;
import model.services.ProductService;

public class Principal {
	public static void main (String [] args) {
		
		List<Product> prod = new ArrayList<>();
		
		prod.add(new Product("Camiseta", 50.00));
		prod.add(new Product("Tenis", 200.10));
		prod.add(new Product("Camisa", 120.60));
		prod.add(new Product("Sapato", 250.00));
		
		
		ProductService ps = new ProductService();
		
		Predicate<Product> criteria = (p) -> {
			return p.getName().charAt(0) == 'C';
		};
		
		double sum = ps.filteredSum(prod, criteria); // função (criteria) dentro de outra função (filteredSum). 
													 // Programação de primeira ordem é passar uma função dentro de outra. É por meio de programação funcional
		
		System.out.println("Soma = " + String.format("%.2f", sum));
	}
}
