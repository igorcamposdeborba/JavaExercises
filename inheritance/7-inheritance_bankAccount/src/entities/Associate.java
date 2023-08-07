package entities;

public class Associate extends Person {

	private int sectorCode;
	private double baseSalary;
	private float taxBase;
	
	public Associate(String name, String address, String telephone, int sectorCode, double baseSalary, float taxBase) {
		super(name, address, telephone);
		
		this.sectorCode = sectorCode;
		this.baseSalary = baseSalary;
		this.taxBase = taxBase;
	}

	// Access methods
	public int getSectorCode() {
		return sectorCode;
	}
	public double getBaseSalary() {
		return baseSalary;
	}
	public float getTaxBase() {
		return taxBase;
	}
	public void setSectorCode(int sectorCode) {
		this.sectorCode = sectorCode;
	}
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	public void setTaxBase(float taxBase) {
		this.taxBase = taxBase;
	}
	
	public double salary() {
		return this.baseSalary - this.baseSalary * this.taxBase;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Setor: " + this.sectorCode + ", Salario Base: " + this.baseSalary + ", Imposto: " + this.taxBase * 100 + "%";
	}
}
