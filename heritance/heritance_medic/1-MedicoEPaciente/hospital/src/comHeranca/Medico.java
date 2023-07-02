package comHeranca;

public class Medico extends Pessoa {
	private int crm;
	private String local;
	
	public Medico (String cpf, String nome, String email, int crm, String local) {
		super(cpf, nome, email);
		this.crm = crm;
		this.local = local;
	}
	
	public int getCrm() {
		return crm;
	}
	public String getLocal() {
		return local;
	}
	
	
	// Não coloquei setCRM porque um médico não muda o CRM porque ele precisa ser instanciado com CRM na criação do objeto (ele só é medico porque tem CRM)
	public void setCrm(String local) {
		this.local = local;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nCRM: " + this.crm + "\nLocal: " + this.local;
	}
}
