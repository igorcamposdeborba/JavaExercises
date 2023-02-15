package composition.challenge;

public class Item {
	private int id;
	private int quantity;
	
	// composition 1:1
	private Product product = new Product();
	
	public Item () {}
	
	public Item (int id, int quantity, Product product) {
		this.id = id;
		this.quantity = quantity;
		this.product = product;
	}
	
	// Access methods
	public int getId() {
		return id;
	}
	public int getQuantity() {
		return quantity;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	// Composition methods
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		product.setName(product.getName());
		product.setPrice(product.getPrice());
	}
	public void removeProduct() {
		this.product = null;
	}
	
	// Default methods
	@Override
	public String toString() {
		return id + ", " + quantity + ", " + product;
	}

}
