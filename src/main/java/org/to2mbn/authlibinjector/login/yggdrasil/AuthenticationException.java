package org.to2mbn.authlibinjector.login.yggdrasil;

/**
 * Thrown when authentication fails.
 *
 * @author yushijinhun
 */
public class AuthenticationException extends Exception {

	private static final long serialVersionUID = 1L;

	public AuthenticationException() {}

	public AuthenticationException(String message, Throwable cause) {
		super(message, cause);
	}

	public AuthenticationException(String message) {
		super(message);
	}

	public AuthenticationException(Throwable cause) {
		super(cause);
	}

}
