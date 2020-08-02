package co.com.test.utility;

import java.io.Serializable;

public class ExceptionHandler extends Throwable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3483247719549888582L;

	public ExceptionHandler() {
		super();
	}

	public ExceptionHandler(String message, Throwable cause) {
		super(message, cause);
	}

	public ExceptionHandler(String message) {
		super(message);
	}

}
