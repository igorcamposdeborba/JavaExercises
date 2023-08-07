package entities;

import java.time.LocalDate;
import java.util.List;

public class Order {
	private Long id;
	private String status;
	private LocalDate orderDate;
	private LocalDate deliveryDate;
	private List<Product> products;
	private Costumer costumer;
	
	public Order() {}
	public Order(Long id, String status, LocalDate orderDate, LocalDate deliveryDate) {
		this.id = id;
		this.status = status;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
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
	
}
