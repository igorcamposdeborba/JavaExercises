package entities;

public class TicketVip extends Ticket {
	private float additionalPrice;
	
	public TicketVip() {}
	public TicketVip(float price, float additionalPrice) {
		super(price);
		
		this.additionalPrice = additionalPrice;
	}
	
	public float getAdditionalPrice() {
		return additionalPrice;
	}
	public void setAdditionalPrice(float additionalPrice) {
		this.additionalPrice = additionalPrice;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(" | preco adicional: R$ ");
		sb.append(String.format("%.2f", this.additionalPrice));
		
		return  sb.toString();
	}
}
