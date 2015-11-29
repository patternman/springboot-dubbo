/**
 * 
 */
package io.springcat.exception;

/**
 * @author adampeng
 *
 */
public class ServerTooBusyException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServerTooBusyException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ServerTooBusyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ServerTooBusyException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ServerTooBusyException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ServerTooBusyException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
