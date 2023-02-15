package composition.challenge;

public class Product {
	
	private int id;
	private String name;
	private double price;
	
	public Product() {}
	
	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	// Access methods
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
 	}
	
	// ! Implement discount logic
	
	// Default methods
	@Override
	public String toString() {
		return id + ", " + name + ", " + price;
	}
	
}
