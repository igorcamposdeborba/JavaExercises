package entities;

import java.util.ArrayList;

public class Dog extends Animal {
	
	ArrayList<Veterinary> veterinary;
	
	public Dog(int id, String name, Veterinary veterinary) {
		super(id, name);
		
		this.veterinary = new ArrayList<Veterinary>();
		this.veterinary.add(veterinary);
	}
	
	
	public ArrayList<Veterinary> getVeterinary(){
		return this.veterinary;
	}
	
	public void setVeterinary(Veterinary veterinary) {
		this.veterinary.add(veterinary);
	}
	
	
	@Override
	public String toString() { // toString: só para imprimir no console com uma string pré-definida por mim
		return super.toString() + this.veterinary;
	}
}
