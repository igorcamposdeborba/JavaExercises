package withdrawException;

// personalized Exception: need always treated
public class withoutBalanceException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public withoutBalanceException(String message) {
		super(message);
	}
}
