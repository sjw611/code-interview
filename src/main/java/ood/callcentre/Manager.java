package ood.callcentre;

import java.util.concurrent.TimeUnit;

public class Manager extends Employee {

	public Manager(String name) {
		super(name);
	}

	@Override
	protected String getPrefix() {
		return "Manager";
	}

	@Override
	protected void answerCallInternal(Call call) {
		System.out.println("Manager " + name + " is not happy");
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
