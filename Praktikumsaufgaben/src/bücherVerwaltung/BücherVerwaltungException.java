package bücherVerwaltung;

public class BücherVerwaltungException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1059749081372973002L;

	public BücherVerwaltungException() {
		super();
	}
	
	public BücherVerwaltungException(String message) {
        super(message);
    }

	public BücherVerwaltungException(String message, Throwable cause) {
        super(message, cause);
    }
	
	public BücherVerwaltungException(Throwable cause) {
        super(cause);
    }
	
	 protected BücherVerwaltungException(String message, Throwable cause,
			 boolean enableSuppression,
			 boolean writableStackTrace) {
		 super(message, cause, enableSuppression, writableStackTrace);
	 }
	
}
