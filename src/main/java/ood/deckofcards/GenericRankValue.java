package ood.deckofcards;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class GenericRankValue implements RankValue {

	private Map<Rank, Set<Integer>> rankValuesCache = new HashMap<>();

	public GenericRankValue() {
		rankValuesCache.put(Rank.ACE, Collections.singleton(1));
		rankValuesCache.put(Rank.TWO, Collections.singleton(2));
		rankValuesCache.put(Rank.THREE, Collections.singleton(3));
		rankValuesCache.put(Rank.FOUR, Collections.singleton(4));
		rankValuesCache.put(Rank.FIVE, Collections.singleton(5));
		rankValuesCache.put(Rank.SIX, Collections.singleton(6));
		rankValuesCache.put(Rank.SEVEN, Collections.singleton(7));
		rankValuesCache.put(Rank.EIGHT, Collections.singleton(8));
		rankValuesCache.put(Rank.NINE, Collections.singleton(9));
		rankValuesCache.put(Rank.TEN, Collections.singleton(10));
		rankValuesCache.put(Rank.JACK, Collections.singleton(11));
		rankValuesCache.put(Rank.QUEEN, Collections.singleton(12));
		rankValuesCache.put(Rank.KING, Collections.singleton(13));
	}

	@Override
	public Set<Integer> getValues(Rank rank) {
		return rankValuesCache.get(Objects.requireNonNull(rank));
	}

}
