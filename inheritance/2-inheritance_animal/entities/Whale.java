package entities;

import entities.enums.Size;

public class Whale extends Animal {
	
	private Size size; // Composição porque compõe (forma) a baleia 
	
	public Whale(int id, String name, Size size) {
		super(id, name);
		this.size = size;
	}
	
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	
	@Override
	public String toString() { // toString: só para imprimir no console com uma string pré-definida por mim
		return super.toString() + ", Tamanho: " + this.size;
	}
}
