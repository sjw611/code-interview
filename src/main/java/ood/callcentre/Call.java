package ood.callcentre;

import java.util.Objects;

public class Call {

	private int id;
	private String message;

	public Call(int id, String message) {
		this.id = id;
		this.message = Objects.requireNonNull(message);
	}

	public int getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}
	
	@Override
	public String toString() {
		return String.format("Call #%d: %s", id, message);
	}
}
