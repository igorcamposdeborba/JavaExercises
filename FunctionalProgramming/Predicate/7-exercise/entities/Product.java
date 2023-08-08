package entities;

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
	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Id: " + this.id 
				+ ", Nome: " + this.name 
				+ ", Categoria: "+ this.category 
				+ ", Preco: R$ " + this.price;
	}
}
