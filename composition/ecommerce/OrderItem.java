package compositionEcommerce;

public class OrderItem {
	private Integer quantity;
	private Double price;
	
	private Product product;// composition: 1 to 1
	
	public OrderItem(Integer quantity, Double price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}
	
	// Methods of access
	public Integer getQuantity() {
		return quantity;
	}
	public Double getPrice() {
		return price;
	}
	public Product getProduct() {
		return product;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	// Method of logic
	public Double subTotal() {
		return quantity * price;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(product.getName());
		sb.append(", R$ " + String.format("%.2f", price) + ", ");
		sb.append(quantity + ", ");
		sb.append("Subtotal: R$ " + String.format("%.2f", subTotal()) + "\n");
		
		return sb.toString();
	}

}
