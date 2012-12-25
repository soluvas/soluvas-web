package org.soluvas.web.site;

/**
 * @author rudi
 *
 */
public class SiteException extends RuntimeException {

	/**
	 * 
	 */
	public SiteException() {
	}

	/**
	 * @param message
	 */
	public SiteException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public SiteException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SiteException(String message, Throwable cause) {
		super(message, cause);
	}

	public SiteException(Throwable cause, String message, Object... args) {
		super(String.format(message, args), cause);
	}

}
