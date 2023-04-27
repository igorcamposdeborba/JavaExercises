package compositionCar;

/* Regra de negócio

Um motor, no aspecto mais básico:
1) Acelera de 10km/h em 10km/h até 100 km/h
2) Freia até parar
*/
public class Motor {
	private int velocity;
	
	public Motor() {
		this.velocity = 0;
	}
	
	// Acccess methods
	public int getVelocity() { // quero saber a velocidade
		return velocity;
	}
	
	// Logic methods	
	public void setAccelerate() { // acelerar
		if (this.velocity < 100) {
			this.velocity += 10;			
		}
	}

	public void setBreak() { // frear
		if (this.velocity > 0) {
			this.velocity = velocity - 10;
		}
	}
	
}
