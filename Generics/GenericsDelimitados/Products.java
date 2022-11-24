package genericsAndFile;

public class Products implements Comparable<Products>{
	private String name;
	private Double price;
	
	public Products(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	@Override
	public String toString() {
		return name + ", " + String.format("%.2f", price);
	}
	public int compareTo(Products otherValue) {
		return price.compareTo(otherValue.getPrice());
	}
}
