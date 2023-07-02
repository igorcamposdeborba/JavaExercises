package comHeranca.Main;

import java.util.HashSet;
import java.util.Scanner;

import comHeranca.Medico;
import comHeranca.Paciente;

public class Principal {
	public static void main(String [] args) {
		// VANTAGEM da Herança aqui: reaproveitar código compartilhado como Nome, Cpf e Email para evitar erro de digitação/cadastro.
		// porque já está buscando as informações que estão cadastradas no sistema
		
		// DESVANTAGEM em todas as arquiteturas: invetavelmente eu vou ter duplicação de objetos se um Medico for um Paciente também. 
		// A menos que eu salve no banco de dados e troque em tempo de execução a instanciação.
		
		
		// MÉDICO João da Silva
		Medico joaoMedico1 = new Medico("02546587945", "João da Silva", "joaodasilva@hotmail.com", 164561, "Av. Assis Brasil 4500 - sala 2");
				
		System.out.println("MEDICO: \n" + joaoMedico1);
		
		
		// PACIENTE: reaproveitei os dados do medico
		Paciente joaoPaciente1 = new Paciente(joaoMedico1.getCpf(), joaoMedico1.getName(), joaoMedico1.getEmail(), "Unimed Plus"); // Desvantagem de não criar dois objetos: eu sobrescrevo e perco os dados do Médico
		
		System.out.println("\nAGORA EH PACIENTE: \n" + joaoPaciente1);
		
		System.out.println("___________________________");
		
		// adicionar objetos no array se HashSet
		Scanner input = new Scanner(System.in);
		HashSet<Medico> medicalSet = new HashSet<Medico>();
		HashSet<Paciente> patientSet = new HashSet<Paciente>();

		String newRegister; // contador para cadastrar outra pessoa
		do {
			System.out.println("\nDigite um numero para cadastrar: 1) Medico OU 2)Paciente");
			String option = input.nextLine();
			
			System.out.println("CPF da pessoa");
			String cpf = input.nextLine();
			System.out.println("Nome e sobrenome");
			String name = input.nextLine();
			System.out.println("E-mail");
			String email = input.nextLine();
			
			switch (option) {
				case "1": {
					System.out.println("Numero do CRM");
					int crm = input.nextInt();
					input.nextLine(); // buffer do int
					System.out.println("Endereco do consultorio");
					String address = input.nextLine();
					
					Medico med1 = new Medico(cpf, name, email, crm, address);
					medicalSet.add(med1);
					break;
				}
				case "2": {
					System.out.println("Nome do plano de saude");
					String planoDeSaude = input.nextLine();
					
					Paciente pac1 = new Paciente(cpf, name, email, planoDeSaude);
					patientSet.add(pac1);
					break;
				}
			}
			System.out.println("Deseja continuar cadastrando? Digite sim ou nao");
			newRegister = input.nextLine();
		
		} while (newRegister.toLowerCase().equalsIgnoreCase("sim") == true);

		
		System.out.println("MEDICOS: " + medicalSet.toString() + "\n");
		System.out.println("PACIENTES: " + patientSet);
	}
}
