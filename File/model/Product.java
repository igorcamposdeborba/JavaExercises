package model;

public abstract class Product {
	private String name;
	private String description;
	private double price;
	
	public Product (String name, String description, double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public double getPrice() {
		return price;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPRice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Produto [nome=" + name + ", descricao=" + description + ", preco=" + price + "]";
	}
	
}