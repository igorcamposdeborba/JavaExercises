package entities;

public class Animal {
	private int id;
	private String name;
	
	protected Animal(int id, String name) { // Coloquei protected para que o Main não consiga instanciar um Animal. Ele precisa especificar qual animal (que é a subclasse Dog ou Whale).
		this.id = id;						// protected: em packages separados, o Main não consegue acessar
		this.name = name;
	}
	
	// Access method
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	// Não coloquei setId porque não vou mudar o ID. 
	// Mas no Spring Boot a injeção de dependência com @Autowired precisa do setId para salvar no banco de dados
	public void SetName(String name) {
		this.name = name;
	}
	
	// Logic method
	public void eat() {
		System.out.println("Comendo");
	}
	
	@Override
	public String toString() { // toString: só para imprimir no console com uma string pré-definida por mim
		return "Id: " + this.id + ", Nome: " + this.name;
	}
}
