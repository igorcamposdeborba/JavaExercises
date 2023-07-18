package principal;

import entities.Car;
import entities.Vehicle;

public class Principal {
	public static void main (String [] args) {
		
		Vehicle v1 = new Car();
		v1.drive();
	}
}
