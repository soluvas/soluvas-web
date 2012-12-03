package org.soluvas.web.site;

/**
 * @author rio
 *
 */
@SuppressWarnings("serial")
public class WebSiteException extends RuntimeException {

	/**
	 * 
	 */
	public WebSiteException() {
		super();
	}

	/**
	 * @param message
	 */
	public WebSiteException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public WebSiteException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public WebSiteException(String message, Throwable cause) {
		super(message, cause);
	}

}
