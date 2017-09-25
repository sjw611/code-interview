package ood.mine;

import java.time.LocalDateTime;

public class Game {
	private LocalDateTime startTime;
	private LocalDateTime endTime;

	private boolean gameOver;
	private boolean gameSuccessful;

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public boolean isGameSuccessful() {
		return gameSuccessful;
	}

	public void setGameSuccessful(boolean gameSuccessful) {
		this.gameSuccessful = gameSuccessful;
	}

}
