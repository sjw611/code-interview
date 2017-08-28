package ood.deckofcards;

public enum Suit {
	CLUB(1), DIAMOND(3), HEART(4), SPADE(2);

	private final int order;

	private Suit(int order) {
		this.order = order;
	}

	public int getOrder() {
		return order;
	}
}
