package comHeranca;

public class Pessoa {
	private String cpf;
	private String name;
	private String email;
	
	protected Pessoa(String cpf, String name, String email) {
		this.cpf = cpf;
		this.name = name;
		this.email = email;
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
	
	public String toString() {
		return "\nCPF: " + this.cpf + "\nNome: " + this.name + "\nEmail: " + this.email;
	}
	
}
