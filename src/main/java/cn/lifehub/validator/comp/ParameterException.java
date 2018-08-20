package cn.lifehub.validator.comp;

public class ParameterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public ParameterException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
