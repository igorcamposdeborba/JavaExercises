package compositionEcommerce;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
	private String name;
	private String email;
	private Date birthDate;
	
	private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
	
	public Client (String name, String email, Date birthDate) {
		this.name = name;
		this.email = validateEmail(email);
		this.birthDate = birthDate;
	}
	
	// Methods of access
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	// Methods of validation
	public String validateEmail(String email) throws IllegalArgumentException {
		if (!email.matches(".+@.+\\..+")) {
			throw new IllegalArgumentException("Formato de email invalido");
		}
		return email;
	}
	
	@Override
	public String toString() { // StringBuilder usado para quando tem muita concatenação para consumir menos memória
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append(" (" + SDF.format(birthDate) + ") " + email);
		
		return sb.toString();
	}

}
