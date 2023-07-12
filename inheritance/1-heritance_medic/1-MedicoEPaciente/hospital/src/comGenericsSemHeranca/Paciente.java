package comGenericsSemHeranca;

import java.util.ArrayList;
import java.util.List;

public class Paciente {
	private String cpf, name, email;
	private String nomePlanoDeSaude; // 1) Pode ser null segundo diagrama UML.
	
	public Paciente(String cpf, String name, String email, String nomePlanoDeSaude) { // crio o objeto com 1 ou nenhum médico
		this.cpf = cpf;
		this.name = name;
		this.email = email;
		this.nomePlanoDeSaude = nomePlanoDeSaude;
	}
	
	public String getNomePlanoDeSaude() {
		return this.nomePlanoDeSaude;
	}
	
	public void setNomePlanoDeSaude(String nomePlano) {
		this.nomePlanoDeSaude = nomePlano;
	}
	
	public String getCpf() {
		return cpf;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	
	// Não coloquei setCpf porque a pessoa não muda de CPF
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return this.cpf 
			 + "\nNome: " + this.name 
			 + "\nEmail: " + this.email 
			 + "\nPlano de Saúde: " + this.nomePlanoDeSaude;
	}
}
