package entities;

public class Seller extends Associate {

	private double sellValue;
	private float commission;
	
	public Seller(Person person, Associate associate, double sellValue, float commission) {
		super(person.getName(), 
			  person.getAddress(),
			  person.getAddress(), 
			  associate.getSectorCode(), 
			  associate.getBaseSalary(), 
			  associate.getTaxBase());
			  
		 this.sellValue = sellValue;
	     this.commission = commission;
	}
	
	// Access methods
	public double getSellValue() {
		return sellValue;
	}
	public float getCommission() {
		return commission;
	}
	
	public void addSellValue(double sellValue) {
		this.sellValue += sellValue;
	}
	public void setCommission(float commission) {
		this.commission = commission;
	}
	
	@Override
	public double salary() {
		return super.salary() + super.getBaseSalary() * this.commission;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Valor total dos itens de vendidos: R$ " + this.sellValue + ", Comissao: " + this.commission * 100 + "%";
	}
}
