package ood.callcentre;

import java.util.ArrayDeque;
import java.util.Deque;

public class CallCentre {

	private Deque<Respondent> respondents = new ArrayDeque<>();
	private Deque<Manager> managers = new ArrayDeque<>();
	private Deque<Director> directors = new ArrayDeque<>();

	public CallCentre() {
		respondents.offerLast(new Respondent("Jack"));
		respondents.offerLast(new Respondent("Queen"));
		respondents.offerLast(new Respondent("King"));

		managers.offerLast(new Manager("Justin"));
		managers.offerLast(new Manager("Jingwei"));

		directors.offerLast(new Director("Jessica"));
	}

	public void dispatchCall(Call call) throws NoEmployeeAvailableException {
		for (Employee e : respondents) {
			if (e.isAvailable()) {
				e.setAvailable(false);

				new Thread(() -> {
					e.answerCall(call);
				}).start();

				e.setAvailable(true);
				return;
			}
		}

		for (Employee e : managers) {
			if (e.isAvailable()) {
				e.setAvailable(false);

				new Thread(() -> {
					e.answerCall(call);
				}).start();

				e.setAvailable(true);
				return;
			}
		}

		for (Employee e : directors) {
			if (e.isAvailable()) {
				e.setAvailable(false);

				new Thread(() -> {
					e.answerCall(call);
				}).start();

				e.setAvailable(true);
				return;
			}
		}

		throw new NoEmployeeAvailableException(call.toString());
	}
}
