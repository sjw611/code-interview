package ood.callcentre;

import java.util.Objects;

public abstract class Employee {

	protected String name;
	protected transient boolean available = true;

	public Employee(String name) {
		this.name = getPrefix() + " " + Objects.requireNonNull(name);
	}

	protected abstract String getPrefix();

	public String getName() {
		return name;
	}

	public void answerCall(Call call) {
		available = false;
		System.out.printf("%s answering call %s\n", name, call);

		answerCallInternal(call);

		available = true;
	}

	protected abstract void answerCallInternal(Call call);

	public boolean isAvailable() {
		return available;
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}
}
