package ood.callcentre;

import java.util.concurrent.TimeUnit;

public class Director extends Employee {

	public Director(String name) {
		super(name);
	}

	@Override
	protected String getPrefix() {
		return "Director";
	}

	@Override
	protected void answerCallInternal(Call call) {
		System.out.println("Manager " + name + " is furious");
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
