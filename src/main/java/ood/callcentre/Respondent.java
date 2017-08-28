package ood.callcentre;

import java.util.concurrent.TimeUnit;

public class Respondent extends Employee {

	public Respondent(String name) {
		super(name);
	}

	@Override
	protected String getPrefix() {
		return "Respondent";
	}

	@Override
	protected void answerCallInternal(Call call) {
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
