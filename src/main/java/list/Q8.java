package list;

import java.util.Objects;

import list.SinglyLinkedList.Node;

public class Q8 {
	public <T> Node<T> loopDetection(SinglyLinkedList<T> list) {
		Objects.requireNonNull(list);

		Node<T> tortoise = list.head(); 
		Node<T> hare = list.head();

		do {
			if (hare == null || hare.next == null) {
				return null;
			}
			hare = hare.next.next;
			tortoise = tortoise.next;
		} while (hare != tortoise);

		hare = list.head();

		while (hare != tortoise) {
			hare = hare.next;
			tortoise = tortoise.next;
		}

		return hare;
	}
}
