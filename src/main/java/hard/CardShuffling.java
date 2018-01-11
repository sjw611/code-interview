package hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class CardShuffling {

	public static void main(String[] args) {
		List<Card> deckOfCards = Deck.allCards();

		System.out.println(deckOfCards);

		shuffle(deckOfCards);

		System.out.println(deckOfCards);
	}

	public static <T> void shuffle(List<T> input) {
		ThreadLocalRandom random = ThreadLocalRandom.current();

		for (int i = 0; i < input.size() - 1; i++) {
			int target = random.nextInt(i + 1, input.size());
			swap(input, i, target);
		}
	}

	public static <T> void swap(List<T> list, int from, int to) {
		checkRange(0, list.size(), from);
		checkRange(0, list.size(), to);

		T tmp = list.get(from);
		list.set(from, list.get(to));
		list.set(to, tmp);
	}

	private static void checkRange(int fromInclusive, int toExclusive, int index) {
		if (index < fromInclusive || index > toExclusive) {
			throw new IndexOutOfBoundsException(index);
		}
	}

	public static enum Face {
		ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
	}

	public static enum Suit {
		HEART, DIAMOND, SPACE, CLUB
	}

	public static class Deck {
		public static List<Card> allCards() {
			Face[] faces = Face.values();
			Suit[] suits = Suit.values();

			List<Card> cards = new ArrayList<>(faces.length * suits.length);

			for (Face face : faces) {
				for (Suit suit : suits) {
					cards.add(new Card(face, suit));
				}
			}

			return cards;
		}
	}

	public static final class Card {
		private final Face face;
		private final Suit suit;

		public Card(Face face, Suit suit) {
			this.face = Objects.requireNonNull(face);
			this.suit = Objects.requireNonNull(suit);
		}

		public Face getFace() {
			return face;
		}

		public Suit getSuit() {
			return suit;
		}

		@Override
		public String toString() {
			return face + " of " + suit;
		}
	}
}
