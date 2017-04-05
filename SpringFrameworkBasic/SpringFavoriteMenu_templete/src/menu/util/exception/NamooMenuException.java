package menu.util.exception;

/**
 * 나무소셜 익셉션
 * @author jiwonpark
 */
public class NamooMenuException extends RuntimeException {
	//
	private static final long serialVersionUID = -8718311926650745043L;

	public NamooMenuException(String message) {
		// 
		super(message, null, false, false); 
	}
	
	public NamooMenuException(Exception exception) {
		//
		super(exception.getClass().getName() + ": " + exception.getMessage(), null, false, false);
	}
}
