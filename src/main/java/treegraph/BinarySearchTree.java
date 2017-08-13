package treegraph;

import java.util.Objects;
import java.util.Random;

public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree<T> {

	private int size = 0;
	private Q6 successor = new Q6();

	public Node<T> getRandomNode() {
		Random rand = new Random();
		int index = rand.nextInt(size);

		Node<T> current = root;

		while (current.left != null) {
			current = current.left;
		}

		for (int i = 0; i < index; ++i) {
			current = successor.successor(current);
		}

		return current;
	}

	@Override
	public boolean insert(T element) {
		Objects.requireNonNull(element);

		root = insert(root, element);
		return true;
	}

	private Node<T> insert(Node<T> current, T element) {
		if (current == null) {
			current = new Node<>(element);
			++size;
		} else if (element.compareTo(current.element) < 0) {
			current.left = insert(current.left, element);
			current.left.parent = current;
		} else if (element.compareTo(current.element) > 0) {
			current.right = insert(current.right, element);
			current.right.parent = current;
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
