package fileReaderWriterTxtToCSV;

public class Product {
	String name;
	double price;
	int quantity;
	
	public Product (String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	// Access methods
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	// Logic methods
	public double totalPrice() {
		return price * quantity;
	}
	
}
