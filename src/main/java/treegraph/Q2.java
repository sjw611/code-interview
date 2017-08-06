package treegraph;

import java.util.Objects;

public class Q2 {
	public <T> Node<T> minimalTree(T[] array) {
		Objects.requireNonNull(array);
		return minimalTree(array, 0, array.length);
	}

	private <T> Node<T> minimalTree(T[] array, int startInclusive, int endExclusive) {
		if (startInclusive >= endExclusive) {
			return null;
		}
		int mid = ((endExclusive - startInclusive) >> 1) + startInclusive;

		Node<T> current = new Node<T>(array[mid]);
		current.left = minimalTree(array, startInclusive, mid);
		current.right = minimalTree(array, mid + 1, endExclusive);

		return current;
	}
}
