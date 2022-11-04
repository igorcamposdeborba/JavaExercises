package inheritance;

public class ImportedProduct extends Product {

	private Double customFee;
	
	public ImportedProduct(String name, Double price, Double customFee) {
		super(name, price);
		this.customFee = customFee;
	}
	
	// Access methods
	public Double getCustomFee() {
		return customFee;
	}
	public void setCustomFee(Double customFee) {
		this.customFee = customFee;
	}
	
	// Logic methods
	public Double totalPrice() {
		return getPrice() + customFee;
	}
	
	@Override
	public String priceTag() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName() + " R$ ");
		sb.append(String.format("%.2f", getPrice()));
		sb.append(" (Customs fee: R$ ");
		sb.append(String.format("%.2f", customFee) + ")");
		
		return sb.toString();
	}
	
}
