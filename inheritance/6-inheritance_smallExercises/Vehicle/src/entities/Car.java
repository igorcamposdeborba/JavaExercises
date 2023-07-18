package entities;

public class Car extends Vehicle {

	public Car() {
		super();
	}
	
	@Override
	public void drive() {
		System.out.println("Repairing a car");
	}
}
