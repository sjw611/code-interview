package treegraph;

import java.util.Objects;

public class Q4 {
	public <T> boolean isBalanced(Node<T> root) {
		Objects.requireNonNull(root);
		return isBalancedRecursive(root);
	}

	private <T> boolean isBalancedRecursive(Node<T> node) {
		if (Math.abs(depth(node.left) - depth(node.right)) > 1) {
			return false;
		}
		if (node.left == null && node.right == null) {
			return true;
		}
		return isBalancedRecursive(node.left) && isBalancedRecursive(node.right);
	}

	private <T> int depth(Node<T> node) {
		if (node == null) {
			return 0;
		}

		if (node.left == null && node.right == null) {
			return 1;
		}

		return 1 + Math.max(depth(node.left), depth(node.right));
	}
}
