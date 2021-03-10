package dateiArbeit;

public class DateiArbeitException extends Exception {

	public DateiArbeitException() {
		super();
	}

	public DateiArbeitException(String message) {
		super(message);
	}

	public DateiArbeitException(Throwable cause) {
		super(cause);
	}

	public DateiArbeitException(String message, Throwable cause) {
		super(message, cause);
	}

	public DateiArbeitException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
