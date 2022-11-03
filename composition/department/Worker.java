package composition;

import java.util.ArrayList;
import java.util.Calendar;

public class Worker {
	private String name;
	private Double baseSalary;
	private WorkerLevel level; // composition: data type. Um worker TEM UM nível
	private Department department; // composition: data type. Um worker TEM UM departamento. E a relação é 1 para 1
	
	private ArrayList<HourContract> contracts = new ArrayList<HourContract>(); // list of contracts of that employee
	// composition: data type HourContracts. Um worker TEM UM ou mais contratos. E a relação é 1 PARA MUITOS.
	
	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}
	
	// access methods
	public String getName() {
		return name;
	}
	public WorkerLevel getWorkerLevel() {
		return level;
	}
	public Double getBaseSalary() {
		return baseSalary;
	}
	public Department getDepartment() {
		return department;
	}
	public ArrayList<HourContract> getContracts() { // Get all contracts in list
		return contracts;
	}
	
	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

	
	// logic methods
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	public void remove(HourContract contract) {
		contracts.remove(contract);
	}
	
	public Double income(Integer year, Integer month) {
		Calendar calendar = Calendar.getInstance(); // get the local calendar time zone
		double salary = this.baseSalary;
		
		for (int i=0; i < this.contracts.size(); i++) {
			calendar.setTime(contracts.get(i).getDate()); // definir a data do contrato como sendo a data do calendar
			int calendar_year = calendar.get(Calendar.YEAR);
			int calendar_month = calendar.get(Calendar.MONTH) + 1; // o mês no Calendar começa com zero
			
			if (year == calendar_year && month == calendar_month) {
				salary += contracts.get(i).totalValue();
			}
		}
		return salary;
	}
	
	
	
	
	
	
	
	
}
