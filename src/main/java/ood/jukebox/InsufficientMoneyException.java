package ood.jukebox;

public class InsufficientMoneyException extends Exception {

	private static final long serialVersionUID = 1L;

	public InsufficientMoneyException(String message) {
		super(message);
	}
}
