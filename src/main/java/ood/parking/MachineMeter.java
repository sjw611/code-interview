package ood.parking;

import java.math.BigDecimal;

public class MachineMeter implements Meter {

	@Override
	public BigDecimal getCost(ParkingSpace space) {
		return BigDecimal.ZERO;
	}

}
