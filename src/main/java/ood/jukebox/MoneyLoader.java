package ood.jukebox;

import java.math.BigDecimal;

public class MoneyLoader {

	private BigDecimal currentBalance = BigDecimal.ZERO;

	public boolean isMoneyLoaded(MusicTrack track) {
		return currentBalance.compareTo(track.getMoney()) >= 0;
	}

	public void deductBalance(MusicTrack track) throws InsufficientMoneyException {
		if (currentBalance.compareTo(track.getMoney()) < 0) {
			throw new InsufficientMoneyException("Insufficient money for track " + track.getMoney());
		} else {
			currentBalance = currentBalance.subtract(track.getMoney());
		}
	}

	public BigDecimal addMoney(BigDecimal money) {
		return currentBalance = currentBalance.add(money);
	}

	protected void clearMoney() {
		currentBalance = BigDecimal.ZERO;
	}
}
