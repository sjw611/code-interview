package ood.parking;

import java.util.ArrayList;

import java.util.List;

public class ParkingLevel {

	private int level;

	private List<ParkingSpace> spaces = new ArrayList<>();

	public ParkingLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	void addParkingSpace(ParkingSpace ps) {
		spaces.add(ps);
	}

	public int getTotalNumberOfSpaces() {
		return spaces.size();
	}

	public int getAvailableSpaces() {
		int t = 0;

		for (ParkingSpace space : spaces) {
			if (space.isAvailable()) {
				++t;
			}
		}

		return t;
	}
}
