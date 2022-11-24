package services;

import java.util.ArrayList;
import java.util.List;

public class PrintService <T> {
	private List <T> valuesArray = new ArrayList<T>(); // array list
	
	public PrintService() {}
	
	
	public void addValue(T value) {
		valuesArray.add(value);
	}
	
	public T first() throws IllegalArgumentException {
		if (valuesArray.size() == 0) {
			throw new IllegalArgumentException("A lista está vazia. Adicione valores na lista.");
		}
		return valuesArray.get(0);
	}
	
	public void print() {
		if (!valuesArray.isEmpty()) {
			System.out.print("[");
			System.out.print(valuesArray.get(0));
		}
		for (int i=1; i<valuesArray.size(); i++) {
			System.out.print(", " + valuesArray.get(i));
		}
		System.out.println("]");
	}
	
}
