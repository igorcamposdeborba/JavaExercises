package abstractShape;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
	public static void main (String [] args) {
		Locale.setDefault(Locale.US);
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite o numero de formas que voce ira calcular a area");
		int shapeQuantity = input.nextInt();
		
		List<Shape> shapeList = new ArrayList<Shape>(); // array list to storage all shapes
		
		
		for (int i=0; i<shapeQuantity; i++) {
			System.out.println("Dados da forma " + (i+1));
			System.out.print("Retangulo ou Circulo? (R ou C) ");
			char shapeDefinition = input.next().charAt(0);
			System.out.print("Cor? (BLACK, BLUE ou RED) ");
			String colorDefinition = input.nextLine().toUpperCase();
			
			
			Shape shape;
			if (shapeDefinition == 'R') {
				input.next(); // buffer of double
				System.out.println("Largura? (em cm)");
				double width = input.nextDouble();
				System.out.println("Altura? (em cm)");
				double height = input.nextDouble();
				
				shape = new Rectangle(width, height); // instantiate child of ABSTRACT class
				
				shapeList.add(shape); // add shape inner list of shapes
				
			} else if (shapeDefinition == 'C') {
				input.next(); // buffer of double
				System.out.println("Raio? (em cm)");
				double radius = input.nextDouble();
				
				shape = new Circle(radius);// instantiate child of ABSTRACT class
				
				shapeList.add(shape); // add shape inner list of shapes
			}
		}
		
		System.out.println("\nArea calculada das formas");
		for (Shape i : shapeList) {
			System.out.println(i.area()); // access ABSTRACT method
		}
		
		input.close();
	}
}
