package comGenericsSemHeranca;

public class Pessoa <T> { // GENERICS (tipo genérico). A ideia da arquitetura do software aqui muda em relação à herança, 
						                            // porque agora esta é uma classe intermediária entre Medico/Paciente e a classe Main
													// para facilitar a instanciação e desacoplar um pouco do código.
	private T person;
	
	// Adicionar
	public void createPerson(T person) {
		this.person = person;
	}
	
	// Get
	public T getPerson() {
		return person;
	}
}
