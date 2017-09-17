package recursive;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PowerSet {
	public <T> Set<Set<T>> enumerate(Set<T> set) {
		Objects.requireNonNull(set);

		Set<Set<T>> result = new HashSet<>();

		for (T element : set) {
			result = enumerate(result, element);
		}

		return result;
	}

	private <T> Set<Set<T>> enumerate(Set<Set<T>> subset, T element) {
		Objects.requireNonNull(subset);
		Objects.requireNonNull(element);

		Set<Set<T>> combined = new HashSet<>(subset);

		for (Set<T> s : subset) {
			Set<T> oneMore = new HashSet<>(s);
			oneMore.add(element);
			combined.add(oneMore);
		}

		combined.add(new HashSet<>());
		combined.add(Collections.singleton(element));

		return combined;
	}
}
