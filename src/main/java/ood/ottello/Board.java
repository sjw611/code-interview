package ood.ottello;

public class Board {

	private static final int DEFAULT_LENGTH = 8;

	private int length;

	private Slot[][] slots;

	public Board(int length) {
		this.length = length;
		init();
	}

	public Board() {
		this(DEFAULT_LENGTH);
	}

	private void init() {
		slots = new Slot[length][length];
		for (int i = 0; i < length; ++i) {
			for (int j = 0; j < length; ++j) {
				slots[i][j] = new Slot(i, j);
			}
		}
		
	}

	public Slot getSlot(int x, int y) {
		if (x < 0 || x >= length || y < 0 || y >= length) {
			throw new IllegalArgumentException();
		}
		return slots[x][y];
	}

	public Disc placeDisc(Side side, int x, int y) {
		Slot slot = getSlot(x, y);

		if (slot.getDisc() != null) {
			throw new UnsupportedOperationException();
		}

		Disc disc = new Disc(side);

		slot.setDisc(disc);

		return disc;
	}

	public Disc flipSide(int x, int y) {
		Slot slot = getSlot(x, y);
		Disc disc = slot.getDisc();

		if (disc == null) {
			throw new IllegalArgumentException();
		}

		disc.setSide(disc.getSide().flip());

		return disc;
	}

	public Disc getLeft(int x, int y) {
		if (x - 1 < 0 || x - 1 >= length || y < 0 || y >= length) {
			throw new IllegalArgumentException();
		}
		return slots[x - 1][y].getDisc();
	}

	public Disc getRight(int x, int y) {
		if (x + 1 < 0 || x + 1 >= length || y < 0 || y >= length) {
			throw new IllegalArgumentException();
		}
		return slots[x + 1][y].getDisc();
	}

	public Disc getUp(int x, int y) {
		if (x < 0 || x >= length || y - 1 < 0 || y - 1 >= length) {
			throw new IllegalArgumentException();
		}
		return slots[x][y - 1].getDisc();
	}

	public Disc getDown(int x, int y) {
		if (x < 0 || x >= length || y + 1 < 0 || y + 1 >= length) {
			throw new IllegalArgumentException();
		}
		return slots[x][y + 1].getDisc();
	}
}
