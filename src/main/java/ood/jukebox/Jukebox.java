package ood.jukebox;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Jukebox {
	private MoneyLoader moneyLoader;
	private Keyboard keyboard;
	private List<MusicTrack> tracks = new ArrayList<>();

	public Jukebox(MoneyLoader moneyLoader, Keyboard keyboard) {
		this.moneyLoader = moneyLoader;
		this.keyboard = keyboard;
	}

	boolean loadMusicTrack(String title, String author, String music, BigDecimal money) {
		return tracks.add(new MusicTrack(title, author, music, money));
	}

	public String play(MusicTrack track) throws InsufficientMoneyException {
		if (moneyLoader.isMoneyLoaded(track)) {
			moneyLoader.deductBalance(track);
			return track.getMusic();
		}
		throw new InsufficientMoneyException("Insufficient money. Requires " + track.getMoney());
	}
	
	public MusicTrack searchMusic() {
		keyboard.getInput();
		// ...
		return null;
	}
}
