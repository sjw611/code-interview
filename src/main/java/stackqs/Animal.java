package stackqs;

import java.time.LocalDateTime;

public abstract class Animal {
	
	protected String name;
	protected LocalDateTime arrivalTime;
	
	public Animal(String name, LocalDateTime arrivalTime) {
		this.name = getNamePrefix() + name;
		this.arrivalTime = arrivalTime;
	}
	
	public abstract String getNamePrefix();
	
	public String getName() {
		return name;
	}
	
	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}
}