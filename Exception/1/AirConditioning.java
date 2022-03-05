package arCondicionado;

import java.util.Scanner;

public class AirConditioning {
	
	private int currentTemperature = 20;
	private String alterateTemp;
	
	public AirConditioning() {}
	
	Scanner input = new Scanner(System.in);
	
	public int validateTemperature(String signal) {
		if (currentTemperature < 17 || currentTemperature > 31) {
			throw new IllegalArgumentException();
		} else {
			if (signal.equals("+")) {
				this.currentTemperature += 1;
				
			} else if (signal.equals("-")) {
				this.currentTemperature -= 1;
			}
		} return currentTemperature;
	}
	
	public int getCurrentTemperature() {
		return currentTemperature;
	}
		
	// aumentar temperatura
	public void raiseTemperature(String raiseTemperature) {
		try {		
			validateTemperature(raiseTemperature);
			
		} catch (IllegalArgumentException e) {
			System.err.println("Erro: você tentou colocar uma temperatura maior que 32 graus");
			throw new IllegalArgumentException(e);
		}
	}
	
	// diminuir temperatura
	public void decreaseTemperature(String decreaseTemperature) {
		try {		
			validateTemperature(decreaseTemperature);
			
		} catch (IllegalArgumentException e) {
			System.err.println("Erro: você tentou colocar uma temperatura menor que 16 graus");
			throw new IllegalArgumentException(e);
		}
	}
	
	// input loop 
	public void inputAlterateTemperature() {
		System.out.println("Aperte + ou - para mudar a temperatura (16 a 32 graus)");
		alterateTemp = input.nextLine();
		
		while (alterateTemp.equals("+") || alterateTemp.equals("-")) {
			if (alterateTemp.equals("+")) {
				raiseTemperature(alterateTemp);
				
			} else if (alterateTemp.equals("-")) {
				decreaseTemperature(alterateTemp);
			}
			System.out.println("Temperatura: " + getCurrentTemperature());
			System.out.println("Aperte + ou - para mudar a temperatura (16 a 32 graus)");
			alterateTemp = input.nextLine();
		}
	}
}
