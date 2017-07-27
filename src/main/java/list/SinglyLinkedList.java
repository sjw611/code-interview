package list;

import java.util.Objects;

public class SinglyLinkedList<T> {

	private Node<T> head;

	public int size() {
		if (isEmpty()) {
			return 0;
		}

		int size = 1;

		Node<T> pointer = head;

		while (pointer.next != null) {
			++size;
			pointer = pointer.next;
		}

		return size;
	}

	public Node<T> append(T data) {
		Objects.requireNonNull(data);

		Node<T> node = new Node<>(data);
		if (isEmpty()) {
			return head = node;
		}

		Node<T> pointer = head;

		while (pointer.next != null) {
			pointer = pointer.next;
		}

		pointer.next = node;

		return node;
	}

	public Node<T> delete(T data) {
		Objects.requireNonNull(data);

		if (isEmpty()) {
			return null;
		}

		Node<T> pointer = head;

		if (head.data.equals(data)) {
			Node<T> result = new Node<>(head);
			head = head.next;
			return result;
		}

		while (pointer.next != null) {
			if (pointer.next.data.equals(data)) {
				Node<T> result = new Node<>(pointer.next);
				pointer.next = pointer.next.next;
				return result;
			}
			pointer = pointer.next;
		}

		return null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public Node<T> head() {
		return head;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Node<T> current = head; current != null; current = current.next) {
			sb.append(current.data).append(" -> ");
		}
		sb.append("(end)");
		return sb.toString();
	}
	
	public static class Node<T> {
		T data;
		Node<T> next;

		Node(T data) {
			this.data = Objects.requireNonNull(data);
		}

		private Node(Node<T> node) {
			this.data = node.data;
			this.next = node.next;
		}

		public T data() {
			return data;
		}
		
		public Node<T> next() {
			return next;
		}
	}

}
