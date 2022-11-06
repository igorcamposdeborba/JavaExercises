package model;

public class Food extends Product {
	private String expirationDate;
	
	public Food (String name, String description, double price, String expirationDate) {
		super(name, description, price);
		this.expirationDate = expirationDate;
	}
	
	public String getExpirationDate() {
		return expirationDate;
	}
	
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	@Override
	public String toString() {
		return "Alimento [ toString()=" + super.toString() + ", dataValidade=" + expirationDate + "]";
	}
}