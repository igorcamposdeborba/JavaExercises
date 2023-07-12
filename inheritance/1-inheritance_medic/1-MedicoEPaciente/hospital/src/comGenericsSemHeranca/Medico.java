package comGenericsSemHeranca;

public class Medico {
	private String cpf, name, email;
	private int crm;
	private String local;
	
	public Medico (String cpf, String name, String email, int crm, String local) {
		this.cpf = cpf;
		this.name = name;
		this.email = email;
		this.crm = crm;
		this.local = local;
	}

	public int getCrm() {
		return crm;
	}
	public String getLocal() {
		return local;
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
	
	// Não coloquei setCRM porque um médico não muda o CRM porque ele precisa ser instanciado com CRM na criação do objeto (ele só é medico porque tem CRM)
	public void setCrm(String local) {
		this.local = local;
	}

	@Override
	public String toString() {
		return this.cpf 
			 + "\nNome: " + this.name 
			 + "\nEmail: " + this.email 
			 + "\nCRM: " + this.crm 
			 + "\nLocal: " + this.local;
	}
}
