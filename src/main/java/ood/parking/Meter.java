package ood.parking;

import java.math.BigDecimal;

public interface Meter {

	BigDecimal getCost(ParkingSpace space);
}
