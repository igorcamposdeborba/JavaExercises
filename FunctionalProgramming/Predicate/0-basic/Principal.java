import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import entities.Product;

public class Principal {
	
	/*Fazer um programa que, a partir de uma lista de produtos, remova da
	lista somente aqueles cujo preço mínimo seja 10.*/
	
	public static void main (String [] args) {
		
		List<Product> productList = new ArrayList<Product>();
		
		productList.add(new Product("Caneta", 1.20));
		productList.add(new Product("Caderno", 19.95));
		productList.add(new Product("Borracha", 0.50));
		productList.add(new Product("Mochila", 119.90));
		
		
		Predicate<Product> removeBiggest = p -> p.getPrice() > 10.00; // Predicate é uma interface de programação funcional que ele testa algo (retorna boolean). Interface só tem 1 método abstrato, que no caso é test()
																	  // expressão lambda é uma arrow function -> 
		
		productList.removeIf(removeBiggest); // remova se o preço for maior que 10.00
		
		System.out.println(productList);
	}
}
