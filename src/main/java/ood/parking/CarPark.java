package ood.parking;

import java.util.HashMap;
import java.util.Map;

public class CarPark {
	private Map<Integer, ParkingLevel> levels = new HashMap<>();

	public CarPark() {
		levels.put(0, new ParkingLevel(0));
		levels.put(1, new ParkingLevel(1));
		levels.put(2, new ParkingLevel(2));
		levels.put(-1, new ParkingLevel(-1));
	}

	public ParkingLevel getParkingLevel(int level) {
		return levels.get(level);
	}
}
