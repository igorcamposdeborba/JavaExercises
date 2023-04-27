package compositionCar;
/* Processo de composição:
	Criar (instanciar) primeiro as partes (objetos) específicas que compõem o Car como o Motor, para depois criar o Car
	Porque primeiro eu tenho que ter as peças para depois juntar tudo. 
*/

public class Test {
	public static void main (String [] args) {
		
		// CRIAR OBJETOS
		Motor motor1 = new Motor(); // COMPOSIÇÃO: criar motor
		
		Car car1 = new Car(Color.WHITE, motor1); // Criar (instanciar) objeto
		
		
		// MOSTRAR OBJETOS
		long id1 = car1.getId();
		Color color1 = car1.getColor();
		
		System.out.println("Chassi: " + id1);
		System.out.println("Cor: " + color1);		
		
		// COMPOSIÇÃO: usar os métodos disponíveis da composição
		System.out.println("\nVelocidade inicial: " + car1.getMotor().getVelocity());
		
		// acelerar
		car1.getMotor().setAccelerate(); // Pegar o carro1 -> Acessar o motor -> ACELERAR
		System.out.println("Velocidade: " + car1.getMotor().getVelocity()); // Mostrar a VELOCIDADE
		
		car1.getMotor().setAccelerate();
		car1.getMotor().setAccelerate();
		System.out.println("Velocidade: " + car1.getMotor().getVelocity());
		
		
		car1.getMotor().setBreak(); // FREAR
		System.out.println("\nVelocidade: " + car1.getMotor().getVelocity());
	}
}
