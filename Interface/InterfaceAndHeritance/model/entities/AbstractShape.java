package model.entities;

import model.enums.Color;

public abstract class AbstractShape implements Shape { // colocar esta super classe (herança) como abstract para que o compilador deixe passar sem a implementação do contrato da interface
	
	private Color color;
	
	public AbstractShape (Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	
}
