package ood.deckofcards;

import java.util.Objects;

public class Card implements Comparable<Card> {

	private final Suit suit;
	private final Rank rank;

	Card(Suit suit, Rank rank) {
		this.suit = Objects.requireNonNull(suit);
		this.rank = Objects.requireNonNull(rank);
	}

	public Suit getSuit() {
		return suit;
	}

	public Rank getRank() {
		return rank;
	}

	@Override
	public String toString() {
		return suit + " of " + rank;
	}

	@Override
	public int compareTo(Card o) {
		int cmp = o.rank.getOrder() - rank.getOrder();
		return cmp != 0 ? cmp : o.suit.getOrder() - suit.getOrder();
	}
}
