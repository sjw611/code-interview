package list;

import java.util.Objects;

public class DoublyLinkedList<T> {

	private final Node<T> head;
	private final Node<T> tail;

	public DoublyLinkedList() {
		head = new Node<>(null);
		tail = new Node<>(null);
		head.next = tail;
		head.prev = tail;
		tail.prev = head;
		tail.next = head;
	}

	public int size() {
		int size = 0;

		for (Node<T> current = head.next; current != tail; current = current.next) {
			++size;
		}

		return size;
	}

	public boolean isEmpty() {
		return head.next == tail;
	}

	public Node<T> add(T data) {
		Objects.requireNonNull(data);
		
		Node<T> node = new Node<>(data);
		
		node.prev = tail.prev;
		node.next = tail;
		tail.prev = node;
		node.prev.next = node;
		
		return node;
	}

	public T removeLast() {
		if (tail.prev == head) {
			return null;
		}

		Node<T> lastNode = tail.prev;
		
		lastNode.next.prev = lastNode.prev;
		lastNode.prev.next = lastNode.next;
		
		return lastNode.data;
	}
	
	public T removeFirst() {
		if (head.next == tail) {
			return null;
		}
		
		Node<T> firstNode = head.next;
		firstNode.next.prev = firstNode.prev;
		firstNode.prev.next = firstNode.next;
		
		return firstNode.data;
	}
	
	public T lastElement() {
		return tail.prev.data;
	}
	
	public T firstElement() {
		return head.next.data;
	}
	
	public Node<T> delete(T data) {
		Objects.requireNonNull(data);
		
		for (Node<T> current = head.next; current != tail; current = current.next) {
			if (current.data.equals(data)) {
				current.next.prev = current.prev;
				current.prev.next = current.next;
				return current;
			}
		}
		
		return null;
	}

	public static class Node<T> {
		private Node<T> prev;
		private Node<T> next;
		private T data;

		public Node(T data) {
			this.data = data;
		}

		public T getData() {
			return data;
		}
	}
}
