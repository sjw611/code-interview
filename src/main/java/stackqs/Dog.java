package stackqs;

import java.time.LocalDateTime;

class Dog extends Animal {

	public Dog(String name, LocalDateTime arrivalTime) {
		super(name, arrivalTime);
	}

	@Override
	public String getNamePrefix() {
		return "Dog-";
	}
}