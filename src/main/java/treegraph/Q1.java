package treegraph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Q1 {

	public <T> boolean routeBetweenNodes(GraphNode<T> n1, GraphNode<T> n2) {
		Objects.requireNonNull(n1);
		Objects.requireNonNull(n2);

		Deque<GraphNode<T>> frontier = new ArrayDeque<>();

		frontier.offerLast(n1);

		Set<GraphNode<T>> visited = new HashSet<>();

		while (!frontier.isEmpty()) {
			GraphNode<T> current = frontier.pollFirst();

			visited.add(current);

			if (current == n2) {
				return true;
			}

			for (GraphNode<T> neighbour : current.neighbours) {
				if (!visited.contains(neighbour)) {
					frontier.offerLast(neighbour);
				}
			}
		}
		return false;
	}
}
