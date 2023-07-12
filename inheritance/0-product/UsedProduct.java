package inheritance;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {
	private Date manufacturedDate;
	
	private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
	
	public UsedProduct(String name, Double price, Date manufacturedDate) {
		super(name, price);
		this.manufacturedDate = manufacturedDate;
	}
	
	// Access methods
	public Date getManufacturedDate() {
		return manufacturedDate;
	}
	public void setManufacturedDate() {
		this.manufacturedDate = manufacturedDate;
	}
	
	// Logic methods
	@Override
	public String priceTag() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName() + " R$ ");
		sb.append(String.format("%.2f", getPrice()));
		sb.append(" (Manufacture date: ");
		sb.append(SDF.format(manufacturedDate) + ")");
		
		return sb.toString();
	}
	
}
