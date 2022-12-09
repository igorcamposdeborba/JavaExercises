import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import entities.Product;

public class Principal {
/*Fazer um programa que, a partir de uma lista de produtos, gere uma
nova lista contendo os nomes dos produtos em caixa alta.*/
	public static void main (String [] args) {
		
		List<Product> list = new ArrayList<Product>();
		
		list.add(new Product ("Table", 400.15));
		list.add(new Product ("Chair", 80.00));
		list.add(new Product ("TV", 1200.47));
		list.add(new Product ("Door", 150.10));
		
		
		// Function recebe e retorna algo como uma stream (sequência de dados). Mas é preciso converter uma List em stream e depois converter stream em List
		Function<Product, String> prod = (p) -> {
			return p.getName().toUpperCase();
		};
		
		List<String> names = list.stream() // transformar a List em stream
							.map(prod) 	   // percorrer e aplicar a cada elemento
							.collect(Collectors.toList()); // voltar como era antes: transformar stream em List
		
		names.forEach(System.out::println); // printar cada elemento da lista
	}
}
