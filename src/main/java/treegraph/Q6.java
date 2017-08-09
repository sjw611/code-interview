package treegraph;

import java.util.Objects;

public class Q6 {
	public <T> Node<T> successor(Node<T> node) {
		Objects.requireNonNull(node);

		if (node.right == null) {
			while (node.parent != null && node.parent.right == node) {
				node = node.parent;
			}
			if (node.parent != null && node.parent.left == node) {
				node = node.parent;
				return node;
			} else {
				return null;
			}
		} else if (node.right != null) {
			node = node.right;

			while (node.left != null) {
				node = node.left;
			}

			return node;
		}

		return null;
	}
}
