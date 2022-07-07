package model.entities;

public class EmptyString extends Exception { // personalized checked exception
	private static final long serialVersionUID = 1L;
	private String name;
	
	public EmptyString (String name) {
		this.name = name;
	}
	
	@Override
	public String getMessage() {
		return String.format("Attribute %s is empty", name);
	}
	
}
