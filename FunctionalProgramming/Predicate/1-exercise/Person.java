package funcional2;

import java.util.UUID;
import java.lang.Comparable;

public class Person implements Comparable<Person> {
	private UUID id;
	private String name;
	private Integer age;
	
	public Person(String name, Integer age) {
		this.id = UUID.randomUUID();
		this.name = name;
		this.age = age;
	}
	
	public UUID getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Integer getAge() {
		return age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id: " + this.id);
		sb.append(" - Name: " + this.name);
		return sb.toString();
	}

	@Override
	public int compareTo(Person person) {
		int compared = this.name.compareTo(person.getName());
		
		return compared;
	}

}
