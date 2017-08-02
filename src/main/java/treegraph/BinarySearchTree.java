package treegraph;

import java.util.Objects;

public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree<T> {

	@Override
	public boolean insert(T element) {
		Objects.requireNonNull(element);

		root = insert(root, element);
		return true;
	}

	private Node<T> insert(Node<T> current, T element) {
		if (current == null) {
			current = new Node<>(element);
		} else if (element.compareTo(current.element) < 0) {
			current.left = insert(current.left, element);
		} else if (element.compareTo(current.element) > 0) {
			current.right = insert(current.right, element);
		}
		return current;
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
