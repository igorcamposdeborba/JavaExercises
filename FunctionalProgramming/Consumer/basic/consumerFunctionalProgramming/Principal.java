package consumerFunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import entities.Product;

/* Fazer um programa que, a partir de uma lista de produtos, aumente o
preço dos produtos em 10%.*/
public class Principal {

	public static void main(String [] args) {
		
		List<Product> list = new ArrayList<>();
		
		list.add(new Product("Notebook", 6300.00));
		list.add(new Product("Keyboard", 100.00));
		list.add(new Product("Mouse", 89.90));
		
		double tax = 1.10; // variavel que aumenta 10% o preço do produto
		
		// Consumer faz algo, ele executa uma ação. Ele tem um método accept abstrato que é void. Esse método é que executa a ação.
		Consumer <Product> addTax = (p) -> { // arrow function (lambda expression)
			p.setPrice(p.getPrice() * tax);
		};
		
				
	}
}
