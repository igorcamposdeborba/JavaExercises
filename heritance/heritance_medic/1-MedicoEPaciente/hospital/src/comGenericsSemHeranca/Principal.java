package comGenericsSemHeranca;

public class Principal {
	public static <T> void main(String [] args) {
		// VANTAGEM do Generics aqui: evitar o acesso direto às classes concretas (entities) por segurança.
		
		// DESVANTAGEM em todas as arquiteturas: invetavelmente eu vou ter duplicação de objetos se um Medico for um Paciente também. 
		// A menos que eu salve no banco de dados e troque em tempo de execução a instanciação.
				
		
		// MÉDICO João da Silva
		Pessoa<Object> joao1 = new Pessoa<Object>(); // Desvantagem no caso de Paciente e Medico: atribuir do tipo object porque estão no mesmo nível pela uml E perco os dados do médico porque sobrescrevo ao reaproveitar código
		
		joao1.createPerson(new Medico ("02546587945", "João da Silva", "joaodasilva@hotmail.com", 164561, "Av. Assis Brasil 4500 - sala 2"));
		
		System.out.println(joao1.getPerson() + "\n");
		
		
		// PACIENTE: agora o Médico é um PACIENTE porque ficou doente
		joao1.createPerson(new Paciente("02546587945", "João da Silva", "joaodasilva@hotmail.com", "Unimed Plus"));
		
		System.out.println(joao1.getPerson() + "\n");
	}
}
