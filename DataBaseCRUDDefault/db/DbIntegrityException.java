package db;

public class DbIntegrityException extends RuntimeException {
	
	public static final long serialVersionUID = 1L;
	
	public DbIntegrityException(String message) {
		super(message);
	}
}
