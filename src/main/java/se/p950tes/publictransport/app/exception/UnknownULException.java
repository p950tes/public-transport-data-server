package se.p950tes.publictransport.app.exception;

public class UnknownULException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UnknownULException() {
		super();
	}

	public UnknownULException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnknownULException(String message) {
		super(message);
	}

	public UnknownULException(Throwable cause) {
		super(cause);
	}

	
}
