package entities;

public class Vendor extends Associate {
	private float percentualCommission;
	
	public Vendor(Associate associate, float percentualCommission) {
		super(associate.getName(), associate.getSalary());
		
		this.percentualCommission = percentualCommission;
	}
	
	public float getPercentualCommission() {
		return percentualCommission;
	}
	public void setPercentualCommission(float percentualCommission) {
		this.percentualCommission = percentualCommission;
	}
	
	// Logic Methods
	private float calculateSalary(){
		float totalSalary = super.getSalary() + (super.getSalary() * percentualCommission);
		
		return totalSalary;
	}
	
	@Override
	public String toString() {
		return super.getName()
				+ "\nSalario sem comissao: R$ " + super.getSalary()
				+ "\nSalario com comissao: R$ " + String.format("%.2f", this.calculateSalary()) 
				+ "\nPercentual de comissao: " + this.percentualCommission + "%";
	}
}
