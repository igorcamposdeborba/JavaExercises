package funcional5;

import java.util.UUID;

public class Animal {

	private UUID id;
	private String name;
	
	public Animal(String name) {
		this.id = UUID.randomUUID();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Id: " + this.id
		   + ", Name: " + this.name;
	}
}
