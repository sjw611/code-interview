package ood.deckofcards;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class DeckOfCards {

	private Set<Card> cards = new TreeSet<>();

	public DeckOfCards() {
		for (Rank rank : Rank.values()) {
			for (Suit suit : Suit.values()) {
				cards.add(new Card(suit, rank));
			}
		}
	}

	public Set<Card> getDeck() {
		return Collections.unmodifiableSet(cards);
	}
}
