package model.entities;

public class OutboundIntervalNumber extends RuntimeException { // unchecked exception
	private static final long serialVersionUID = 1L;
	private String name;
	
	public OutboundIntervalNumber (String name) {
		this.name = name;
	}
	
	@Override
	public String getMessage() {
		return String.format("Attibutes %s is outbound interval", name);
	}
	
	
}
