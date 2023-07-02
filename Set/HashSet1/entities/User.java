package entities;

import java.util.Date;
import java.util.Objects;

public class User {
	private String name;
	private Date date;
	
	public User(String name, Date date) {
		this.name = name;
		this.date = date;
	}
	
	public String getName() {
		return name;
	}
	public Date getDate() {
		return date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(name, other.name);
	}
	
	
}
