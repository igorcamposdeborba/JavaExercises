package entities;

public class HRManager extends Associate<Object> {
	
	public HRManager(double salary) {
		super(salary);
	}
	
	@Override
	public void work() {
		System.out.println("HR practitioner working");
	}

	@Override
	public String toString() {
		return "Salario: " + super.getSalary() + ", Associados: " + super.getAssociateList();
	}
	
	
}
