package compositionEcommerce;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private Date moment;
	private OrderStatus status;
	
	Client client; // composition: 1 to 1
	public List<OrderItem> orderItems = new ArrayList<OrderItem>(); // composition: 1 to many
	
	private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
	
	public Order(Client client, Date moment, OrderStatus status) {
		this.client = client;
		this.moment = moment;
		this.status = status;
	}
	
	// Methods of access
	public Date getMoment() {
		return moment;
	}
	public OrderStatus getOrderStatus() {
		return status;
	}
	public Client getClient() {
		return client;
	}
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	public void setOrderStatus(OrderStatus status) {
		this.status = status;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	// Methods of logic 
	public void addItem(OrderItem item) {
		orderItems.add(item);
	}
	public void removeItem(OrderItem item) {
		orderItems.remove(item);
	}
	public Double total() {
		double sumTotal = 0.0;
		for (OrderItem i : orderItems) {
			sumTotal += i.subTotal();
		}
		return sumTotal;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Data do pedido: " + SDF.format(moment) + "\n");
		sb.append("Status do pedido: " + status + "\n");
		sb.append("Cliente: " + client + "\n"); // composition access
		
		sb.append("Order Items: " + "\n");
		for (OrderItem i : orderItems) { // print all order items
			sb.append(i + "\n");
		}
		sb.append("Preco total: " + String.format("%.2f", total()));
		return sb.toString();
	}
	
	
}
