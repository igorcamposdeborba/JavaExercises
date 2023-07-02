package entities;

public class Veterinary {
	private String name;
	
	public Veterinary(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() { // toString: só para imprimir no console com uma string pré-definida por mim
		return ", Veterinária: " + this.name;
	}
}
