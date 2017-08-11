package treegraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Q7 {

	public List<GraphNode<String>> buildOrder(Set<GraphNode<String>> projects) {
		Objects.requireNonNull(projects);

		List<GraphNode<String>> buildOrder = new ArrayList<>();
		Map<GraphNode<String>, State> states = new HashMap<>();

		for (GraphNode<String> project : projects) {
			states.put(project, State.NOT_VISITED);
		}

		for (GraphNode<String> project : projects) {
			if (states.get(project) == State.NOT_VISITED) {
				buildOrder(project, buildOrder, states);
			}
		}

		return buildOrder;
	}

	private static enum State {
		COMPLETED, PARTIAL, NOT_VISITED;
	}

	private void buildOrder(GraphNode<String> node, List<GraphNode<String>> order,
			Map<GraphNode<String>, State> states) {
		Objects.requireNonNull(node);

		if (states.get(node) == State.PARTIAL) {
			throw new NoBuildOrderAvailableException();
		}

		if (states.get(node) == State.NOT_VISITED) {

			states.put(node, State.PARTIAL);

			for (GraphNode<String> neighbour : node.neighbours) {
				buildOrder(neighbour, order, states);
			}

			states.put(node, State.COMPLETED);
			order.add(node);
		}
	}

	static class NoBuildOrderAvailableException extends RuntimeException {
		private static final long serialVersionUID = 1L;

	}
}
