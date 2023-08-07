package entities;

public class WorkMan extends Associate {
	private double productionValue;
	private float commission;
	
	public WorkMan(Person person, Associate associate, double productionValue, float commission) {
		super(person.getName(), 
			  person.getAddress(),
			  person.getAddress(), 
			  associate.getSectorCode(), 
			  associate.getBaseSalary(), 
			  associate.getTaxBase());
			  
		 this.productionValue = productionValue;
	     this.commission = commission;
	}
	
	// Access methods
	public double getProductionValue() {
		return productionValue;
	}
	public float getCommission() {
		return commission;
	}
	
	public void addProductionValue(double amount) {
		this.productionValue = amount;
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
		return super.toString() + ", Valor total dos itens de producao: R$ " + this.productionValue + ", Comissao: " + this.commission * 100 + "%";
	}
}
