package arCondicionado;

public class TestAirConditioning {
	public static void main (String [] args) {
			
		AirConditioning air = new AirConditioning();
		System.out.println("Temperatura inicial: " + air.getCurrentTemperature());
		
		air.inputAlterateTemperature();
		
		
	}
}
