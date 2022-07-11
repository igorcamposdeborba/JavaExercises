package entities;

public class Average {
	private double total;
	private int quantity;
	
	public Average() {}
	
	
	
	public Average add(double value) {
		total += value;
		quantity++;
		return this;
	}
	
	public double getValue() {
		return total / quantity;
	}
	
	public static Average blend (Average m1, Average m2) {
		Average result = new Average();
		
		result.total = m1.total = m2.total;
		result.quantity = m1.quantity + m2.quantity;
		
		return result;
	}
}
