package org.soluvas.web.login;

@SuppressWarnings("serial")
public class LoginException extends RuntimeException {

	public LoginException() {
		super();
	}

	public LoginException(String message, Throwable cause) {
		super(message, cause);
	}

	public LoginException(String message) {
		super(message);
	}

	public LoginException(Throwable cause) {
		super(cause);
	}

	public LoginException(Throwable cause, String message, Object... args) {
		super(String.format(message, args), cause);
	}

}
