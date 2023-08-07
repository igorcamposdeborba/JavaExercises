package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import entities.Product;

// Exercise 1 — Obtain a list of products belongs to category “Books” with price > 100

public class Principal {
	public static void main(String [] args) {
		
		List<Product> productList1 = new ArrayList<Product>();
		productList1.add(new Product(0L, "Harry Potter", "Books", 156.78));
		productList1.add(new Product(1L, "Spider Man", "Movie", 19.90));
		productList1.add(new Product(2L, "Marketing", "Books", 89.20));
		productList1.add(new Product(3L, "Java: como programar", "Books", 466.46));

		List<Product> bookProductGreather100 = productList1.stream()
																.filter(book -> Objects.equals(book.getCategory(), "Books"))
																.filter(book -> book.getPrice() > 100.0)
																.collect(Collectors.toList());
		System.out.println(bookProductGreather100);
	}
}