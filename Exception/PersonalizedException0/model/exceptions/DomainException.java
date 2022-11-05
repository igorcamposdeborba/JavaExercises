package model.exceptions;

public class DomainException extends Exception { // checked exception
	private static final long serialVersionUID = 1L;
	
	public DomainException(String message) {
		super(message); // armazenar mensagem dentro da exceção DomainException
	}
}
