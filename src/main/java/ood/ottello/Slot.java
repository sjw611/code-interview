package ood.ottello;

public class Slot {

	private Disc disc;
	private int x;
	private int y;

	public Slot(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setDisc(Disc disc) {
		this.disc = disc;
	}

	public void reset() {
		setDisc(null);
	}

	public Disc getDisc() {
		return disc;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
