package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
	private Long id;
	private String status;
	private LocalDate orderDate;
	private LocalDate deliveryDate;
	
	private List<Product> products = new ArrayList<>();
	private Costumer costumer;
	
	public Order() {}
	public Order(Long id, String status, LocalDate orderDate, LocalDate deliveryDate, Product product, Costumer costumer) {
		this.id = id;
		this.status = status;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		
		this.products.add(product);
		this.costumer = costumer;
	}
	
	public Long getId() {
		return id;
	}
	public String getStatus() {
		return status;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}
	public List<Product> getProducts(){
		return products;
	}
	public Costumer getCostumer() {
		return costumer;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public void addProducts(Product product) {
		this.products.add(product);
	}
	public void setCostumer(Costumer costumer) {
		this.costumer = costumer;
	}
	
	@Override
	public String toString() {
		return "id: " + id 
				+ ", Status: " + status 
				+ ", Data do pedido: " + orderDate 
				+ ", Data da entrega: " + deliveryDate 
				+ ", Produtos: " + products 
				+ ", Cliente: " + costumer;
	}
}
