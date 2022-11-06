package model;

public class HomeAppliance extends Product {
	private double ipi;
	
	public HomeAppliance (String name, String description, double price, double ipi) {
		super(name, description, price);
		this.ipi = ipi;
	}
	
	public double getIpi() {
		return ipi;
	}
	
	public void setIpi(double ipi) {
		this.ipi = ipi;
	}
	
	@Override
	public String toString() {
	return "HomeAppliance [ toString()=" + super.toString() + ", ipi=" + ipi + "]";
	}
}
 