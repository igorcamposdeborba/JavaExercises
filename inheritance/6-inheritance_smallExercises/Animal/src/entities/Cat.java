package entities;

public class Cat extends Animal {

	public Cat () {
		super();
	}
	
	@Override
	public void makeSound() {
		System.out.println("Miau");
	}
	
	public void moviment() {
		System.out.println("Gato se movimentando");
	}
}
