package inheritance;

public class Product {
	
	private String name;
	private Double price;
	
	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	
	// Access methods
	public String getName() {
		return name;
	}
	public Double getPrice() {
		return price;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	// Logic methods
	public String priceTag() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName() + " R$ ");
		sb.append(String.format("%.2f", getPrice()));
		
		return sb.toString();
	}
}
