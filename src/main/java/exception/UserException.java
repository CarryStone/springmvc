package exception;

public class UserException extends Exception{

	/**
	 * author lirenjie
	 * date: 2018-11-17
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public UserException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
