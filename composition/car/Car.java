package compositionCar;

// OBJETIVO: Separar partes de um objeto com composição. Este objeto é um carro com motor.
// Conceito: composição é uma peça que eu posso colocar para compor/formar o objeto, 
// mas ele não é o próprio objeto inteiramente por si só. E eu posso usar essa composição em outros tipos de objetos.

/* Regra de negócio:
Um carro no aspecto mais básico: 
1) tem placa, <- atributo/característica do carro
2) tem cor,    <- atributo/característica do carro

3) acelera, <- COMPOSIÇÃO no motor
4) freia   <- COMPOSIÇÃO no motor
*/

public class Car {
	private long id; // id do chassi
	private Color color; // cores possíveis - enum de cor (BLACK, WHITE, BLUE)
	
	// COMPOSIÇÃO - este atributo me permite ACESSAR ATRIBUTOS E MÉTODOS da classe Motor.
	// Regra para saber se é composição: TEM UM - um Car TEM UM Motor? Sim, é composição. Então coloca no atributo o tipo da classe
	// Regra para saber se é herança: É UM - um Dog É UM Animal? Sim, é herança. Então extends
	private Motor motor; // <- COMPOSIÇÃO
	
	public Car(Color color, Motor motor) { // criar (instanciar) objeto Carro
		this.id = (int) (Math.random() * 100) + 1; // criar id aleatório entre 0 e 100
		this.color = color;
		this.motor = motor; // COMPOSIÇÃO: criar objeto Motor
	}
	
	
	// Access methods
	public long getId() {
		return id;
	}
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	// Composition methods
	public Motor getMotor() { // Acessar métodos da COMPOSIÇÃO
		return motor;
	}
	
}
