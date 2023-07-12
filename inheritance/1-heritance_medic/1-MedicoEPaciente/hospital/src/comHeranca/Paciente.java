package comHeranca;

import java.util.ArrayList;
import java.util.List;

public class Paciente extends Pessoa {
	private String nomePlanoDeSaude; // 1) Pode ser null segundo diagrama UML.
	
	public Paciente(String cpf, String name, String email, String NomePlanoDeSaude) { // crio o objeto com 1 ou nenhum médico
		super(cpf, name, email);
		this.nomePlanoDeSaude = NomePlanoDeSaude;
	}
	
	
	public String getNomePlanoDeSaude() {
		return this.nomePlanoDeSaude;
	}
	
	public void setNomePlanoDeSaude(String nomePlano) {
		this.nomePlanoDeSaude = nomePlano;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nPlano de Saúde: " + this.nomePlanoDeSaude;
	}
}
