package se.p950tes.publictransport.app.exception;

public class ResponseParsingException extends RuntimeException {

	private static final long serialVersionUID = 1L;


	public ResponseParsingException(String message) {
		super(message);
	}

	public ResponseParsingException(Throwable cause) {
		super(cause);
	}

	public ResponseParsingException(String message, Throwable cause) {
		super(message, cause);
	}
}
