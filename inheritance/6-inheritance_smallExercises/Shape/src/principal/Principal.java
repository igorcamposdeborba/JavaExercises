package principal;

import entities.Rectangle;
import entities.Shape;

public class Principal {
	public static void main(String [] args) {
		Shape shape1 = new Rectangle(3, 3);
		
		System.out.println(shape1);
	}
}
