package entities;

public class Person {
	private String name, 
				   address,
				   telephone;
	
	public Person(String name, String address, String telephone) {
		this.name = name;
		this.address = address;
		this.telephone = telephone;
	}
	public Person(String name, String telephone) {
		this.name = name;
		this.telephone = telephone;
	}
	public Person(String name) {
		this.name = name;
	}

	// Access methods
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getTelephone() {
		return address;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@Override
	public String toString() {
		return "Nome: " + name + ", Telefone: "+ telephone + ", Endereco: " + address;
	}
}
