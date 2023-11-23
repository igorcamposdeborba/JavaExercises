package test;

public class Principal {
	public static void main(String [] args) {
		
		// Pattern Matching: nova forma de switch do java 17
		
		String day = "Sunday";
		
		String print = switch(day) { // atribuir switch a uma variável
			case "Saturday", "Sunday" -> "1- Weekend"; // lambda expression que atribui à variável print o valor Weekend
			case "Friday", "Thursday", "Wednesday", "Tuesday", "Monday" -> { // bloco de código é obrigatório retornar yield
				yield "2- Weekday";
			}
			default -> "";
		};
		
		System.out.println(print);
		
	}
}
