package entities;

import java.util.ArrayList;
import java.util.List;

public class Associate<T> {
	private double salary;
	private List<T> associateList = new ArrayList<>();
	
	public Associate(double salary) {
		this.salary = salary;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void work() {
		System.out.println("Working");
	}
	
	public List<T> getAssociateList(){
		return associateList;
	}
	public T getAssociateByIndex(int index) {
		return associateList.get(index);
	}
	public void addAssociate(T associate) {
		this.associateList.add(associate);
	}
	
}
