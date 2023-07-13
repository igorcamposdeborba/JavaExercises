package funcional5;

public class Dog extends Animal {
	private boolean vacinated;
	
	public Dog(String name, boolean vacinated) {
		super(name);
		this.vacinated = vacinated;
	}
	
	public boolean getVacinated() {
		return vacinated;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Vacinated: " + this.vacinated;
	}
}
