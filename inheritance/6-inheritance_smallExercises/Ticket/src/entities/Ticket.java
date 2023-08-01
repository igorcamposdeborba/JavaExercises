package entities;

public class Ticket {
	private float price;
	
	public Ticket() {}
	public Ticket(float price) {
		this.price = price;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Preco padrao: R$ " + String.format("%.2f", price );
	}
}
