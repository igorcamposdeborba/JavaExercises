package entities;

import java.util.Objects;

public class Product {
	private Long id;
	private String name;
	private String category;
	private Double price;
	
	public Product() {}
	public Product(Long id, String name, String category, Double price) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCategory() {
		return category;
	}
	public Double getPrice() {
		return price;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double setPrice(Double price) {
		this.price = price;
		return price;
	}
	
	public static Product setDiscount(Product product, Float discountRate) {
		Product changedProducPrice = product;
		
		if (Objects.nonNull(discountRate) && Objects.nonNull(discountRate)) {
			changedProducPrice = verifyDiscount(product, discountRate);
		}
		return changedProducPrice;
	}
	
	public static Product verifyDiscount(Product product, float discountRate) {
		double priceDiscounted = product.getPrice() * (1 - discountRate);
		product.setPrice(priceDiscounted);
		
		return product;
	}
	
	
	@Override
	public String toString() {
		return "Id: " + this.id 
				+ ", Nome: " + this.name 
				+ ", Categoria: "+ this.category 
				+ ", Preco: R$ " + this.price;
	}
}
