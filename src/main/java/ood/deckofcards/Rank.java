package ood.deckofcards;

public enum Rank {

	ACE(2), TWO(1), THREE(13), FOUR(12), FIVE(11), SIX(10), SEVEN(9), EIGHT(8), NINE(7), TEN(6), JACK(5), QUEEN(
			4), KING(3);
	
	private final int order;

	private Rank(int order) {
		this.order = order;
	}
	
	int getOrder() {
		return order;
	}
}
