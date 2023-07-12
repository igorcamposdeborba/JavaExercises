package entities;

import java.util.UUID;

public class Associate {
	private UUID id;
	private String firstName, lastName;
	
	Department department; // association
	
	public Associate(String firstName, String lastName, Department department) {
		this.id = UUID.randomUUID();
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.department = department;
	}
	
	// Access methods
	public UUID getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id: " + this.id);
		sb.append(" - Nome: " + this.firstName);
		sb.append(" - Sobrenome: " + this.lastName);
		
		return sb.toString();
	}
}
