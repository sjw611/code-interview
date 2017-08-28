package ood.callcentre;

public class NoEmployeeAvailableException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoEmployeeAvailableException(String message) {
		super(message);
	}
}
