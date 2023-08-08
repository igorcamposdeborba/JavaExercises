package principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import entities.Costumer;
import entities.Order;
import entities.Product;

public class Principal4 {
	public static void main(String [] args) {
		List<Product> productList1 = new ArrayList<Product>();
		productList1.add(new Product(0L, "Harry Potter", "Books", 156.78));
		productList1.add(new Product(1L, "Spider Man Puppet", "Toys", 19.90));
		productList1.add(new Product(2L, "Bear Toy", "Toys", 89.20));
		productList1.add(new Product(3L, "Java: como programar", "Books", 466.46));
		productList1.add(new Product(4L, "Infantil pants", "Toys", 89.45));
		
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
		
		// Exercise 4 — Obtain a list of products ordered by customer of tier 2 between 01-Feb-2023 and 01-Dec-2023
		// Variável: interface funcional para guardar lógica:
		Predicate<Order> isTier2 = costumer -> costumer.getCostumer().getTier() == 2;
		Predicate<Order> start01Feb2023 = order -> order.getOrderDate().compareTo(LocalDate.of(2023, 2, 1)) >= 0;
		Predicate<Order> end01Dec2023 = order -> order.getOrderDate().compareTo(LocalDate.of(2023, 8, 7)) <= 0;		
		
		// Usar a lógica da variável:
		List<Order> productsRangeDate = orderList1.stream()
														.filter(isTier2) // Aplicar a lógica
														.filter(start01Feb2023)
														.filter(end01Dec2023)
														.distinct()
														.collect(Collectors.toList());
	
		System.out.println(productsRangeDate);
	}
}
