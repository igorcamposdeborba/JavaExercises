package application;

import model.entities.ComboDevice;

public class Program {
	public static void main (String [] args) {
		
		ComboDevice combo = new ComboDevice("3025");
		
		combo.processDoc("Text example");
		combo.print("Text example");
		System.out.println("Scan result: " + combo.scan());
	}
}
