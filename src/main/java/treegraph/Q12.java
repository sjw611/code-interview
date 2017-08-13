package treegraph;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class Q12 {
	public long countPathsWithSum(long sum, Node<Integer> root) {
		Objects.requireNonNull(root);
		AtomicLong count = new AtomicLong();

		countPathsWithSum(sum, root, count);

		return count.get();
	}

	private void countPathsWithSum(long sum, Node<Integer> root, AtomicLong count) {
		if (root != null) {
			countPathsWithSumFromNode(sum, 0L, root, count);
			countPathsWithSum(sum, root.left, count);
			countPathsWithSum(sum, root.right, count);
		}
	}

	private void countPathsWithSumFromNode(long target, long currentSum, Node<Integer> node, AtomicLong count) {
		if (node == null) {
			return;
		}

		long newSum = node.element + currentSum;

		if (newSum == target) {
			count.incrementAndGet();
		}

		countPathsWithSumFromNode(target, newSum, node.left, count);
		countPathsWithSumFromNode(target, newSum, node.right, count);
	}
}
