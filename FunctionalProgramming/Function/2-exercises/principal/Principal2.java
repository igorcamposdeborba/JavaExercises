package principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import entities.Costumer;
import entities.Order;
import entities.Product;

public class Principal2 {
	public static void main(String [] args) {
		List<Product> productList1 = new ArrayList<Product>();
		productList1.add(new Product(0L, "Harry Potter", "Books", 156.78));
		productList1.add(new Product(1L, "Spider Man Puppet", "Baby", 19.90));
		productList1.add(new Product(2L, "Bear Toy", "Baby", 89.20));
		productList1.add(new Product(3L, "Java: como programar", "Books", 466.46));
		productList1.add(new Product(4L, "Infantil pants", "Baby", 89.45));
		
		List<Costumer> costumerList1 = new ArrayList<>();
		costumerList1.add(new Costumer(0L, "Igor Borba", 2));
		costumerList1.add(new Costumer(1L, "Ana Silva", 1));
		costumerList1.add(new Costumer(2L, "Carla Fontoura", 3));
		costumerList1.add(new Costumer(3L, "Marcos", 1));
		
		List<Order> orderList1 = new ArrayList<Order>();
		orderList1.add(new Order(0L, "COMPLETED", LocalDate.now(), LocalDate.now(), productList1.get(1), costumerList1.get(0)));
		orderList1.add(new Order(1L, "DELIVERING", LocalDate.now(), LocalDate.now(), productList1.get(0), costumerList1.get(1)));
		orderList1.add(new Order(1L, "REQUESTED", LocalDate.now(), LocalDate.now(), productList1.get(2), costumerList1.get(0)));
		orderList1.add(new Order(1L, "COMPLETED", LocalDate.now(), LocalDate.now(), productList1.get(3), costumerList1.get(0)));
		
		// Exercise 2 — Obtain a list of order with products belong to category “Baby”
		// Variável: interface funcional para guardar lógica:
		Predicate<Order> isCategoryBaby = orderItem -> orderItem.getProducts()
															.stream() // Predicate: boolean para testar se o produto atual é da categoria Baby
															.anyMatch(category -> category.getCategory().equalsIgnoreCase("Baby"));
		
		// Usar a lógica da variável:
		List<Order> productsCategoryBaby = orderList1.stream()
														.filter(isCategoryBaby) // Aplicar a lógica
														.collect(Collectors.toList());
	
		System.out.println(productsCategoryBaby);
	}
}
