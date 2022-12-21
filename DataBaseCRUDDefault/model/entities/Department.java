package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Department implements Serializable {
	private Integer id;
	private String name;
	
	private static final long serialVersionUID = 1L;
	
	public Department (Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Department () {}
	
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	
	public String toString() {
		return "Department [id=" + getId() + ", name=" + getName() + "]";
	}
	
	
	
}
