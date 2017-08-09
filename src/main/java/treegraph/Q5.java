package treegraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Q5 {
	public <T extends Comparable<? super T>> boolean isBst(Node<T> root) {
		Objects.requireNonNull(root);

		List<T> elements = new ArrayList<>();

		inOrderTraversal(root, elements);

		return isSorted(elements);
	}

	private <T extends Comparable<? super T>> void inOrderTraversal(Node<T> node, List<T> elements) {
		if (node != null) {
			inOrderTraversal(node.left, elements);
			elements.add(node.element);
			inOrderTraversal(node.right, elements);
		}
	}

	private <T extends Comparable<? super T>> boolean isSorted(List<T> elements) {
		Objects.requireNonNull(elements);
		if (elements.isEmpty() || elements.size() == 1) {
			return true;
		}
		
		for (int i = 0; i < elements.size() - 1; ++i) {
			if (elements.get(i).compareTo(elements.get(i + 1)) > 0) {
				return false;
			}
		}
		return true;
	}
}
