package principal;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import entities.Associate;
import entities.Manager;
import entities.Vendor;

public class Principal {
	public static void main (String [] args) {
		Locale.setDefault(new Locale("en", "US"));
		
		Associate associate1 = new Associate("Carla", 5000.0F);
		Associate associate2 = new Associate("Marcos", 4500.12F);
		
		Manager manager1 = new Manager(associate1, "TI");
		Vendor vendor1 = new Vendor(associate2, 0.05F);
		
		System.out.println("Associado 1 " + associate1);
		System.out.println("Associado 2 " + associate2);
		System.out.println("\nGerente " + manager1);
		System.out.println("\nVendedor " + vendor1);
	}
}
