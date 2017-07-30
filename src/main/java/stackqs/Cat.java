package stackqs;

import java.time.LocalDateTime;

class Cat extends Animal {
	
	public Cat(String name, LocalDateTime arrivalTime) {
		super(name, arrivalTime);
	}

	@Override
	public String getNamePrefix() {
		return "Cat-";
	}
}