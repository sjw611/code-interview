package treegraph;

import java.util.Objects;

public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree<T> {

	@Override
	public boolean insert(T element) {
		Objects.requireNonNull(element);

		if (root == null) {
			root = new Node<>(element);
			return true;
		}

		Node<T> current = root;

		while (true) {
			if (element.compareTo(current.element) == 0) {
				return false;
			} else if (element.compareTo(current.element) < 0) {
				if (current.left == null) {
					current.left = new Node<>(element);
					return true;
				} else {
					current = current.left;
				}
			} else {
				if (current.right == null) {
					current.right = new Node<>(element);
					return true;
				} else {
					current = current.right;
				}
			}
		}
	}

	@Override
	public Node<T> find(T element) {
		Objects.requireNonNull(element);
		return find(root, element);
	}

	private Node<T> find(Node<T> current, T element) {
		if (current == null) {
			return null;
		} else if (element.compareTo(current.element) == 0) {
			return current;
		} else if (element.compareTo(current.element) < 0) {
			return find(current.left, element);
		} else {
			return find(current.right, element);
		}
	}
}
