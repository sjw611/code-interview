package ood.jukebox;

import java.math.BigDecimal;
import java.util.Objects;

public class MusicTrack {
	private String title;
	private String author;
	private String music;
	private BigDecimal money;

	public MusicTrack(String title, String author, String music, BigDecimal money) {
		this.title = Objects.requireNonNull(title);
		this.author = Objects.requireNonNull(author);
		this.music = Objects.requireNonNull(music);
		this.money = Objects.requireNonNull(money);
	}

	public String getAuthor() {
		return author;
	}

	public String getMusic() {
		return music;
	}

	public String getTitle() {
		return title;
	}

	public BigDecimal getMoney() {return money;
	}
}
