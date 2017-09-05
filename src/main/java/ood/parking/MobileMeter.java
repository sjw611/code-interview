package ood.parking;

import java.math.BigDecimal;

public class MobileMeter implements Meter {

	@Override
	public BigDecimal getCost(ParkingSpace space) {
		return BigDecimal.ZERO;
	}

}
