package treegraph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Q3 {
	public <T> List<List<Node<T>>> listOfDepths(Node<T> root) {
		Objects.requireNonNull(root);

		List<List<Node<T>>> list = new LinkedList<>();

		List<Node<T>> nextLevel = Arrays.asList(root);

		while (!nextLevel.isEmpty()) {
			list.add(nextLevel);
			nextLevel = nextLevel(nextLevel);
		}

		return list;

	}

	private <T> List<Node<T>> nextLevel(List<Node<T>> currentLevel) {
		Objects.requireNonNull(currentLevel);
		List<Node<T>> next = new LinkedList<>();

		for (Node<T> node : currentLevel) {
			if (node.left != null) {
				next.add(node.left);
			}
			if (node.right != null) {
				next.add(node.right);
			}
		}

		return next;
	}
}
