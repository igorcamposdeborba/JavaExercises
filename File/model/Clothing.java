package model;

public class Clothing extends Product {
	private int stockQuantity;
	
	public Clothing(String name, String description, double price, int stockQuantity) {
		super(name, description, price);
		this.stockQuantity = stockQuantity;
	}
	
	public int getStockQuantity () {
		return stockQuantity;
	}
	
	public void setStockQuantity (int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	@Override
	public String toString() {
		return "Alimento [ toString()=" + super.toString() + ", stockQuantity=" + stockQuantity + "]";
	}
}