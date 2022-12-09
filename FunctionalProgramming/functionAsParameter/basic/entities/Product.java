package entities;

import java.util.List;
import java.util.function.Predicate;

public class Product {
	private String name;
	private double price;
	
	public Product(String name, double price){
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return getName() + " R$ " + getPrice();
	}

}
