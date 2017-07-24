package list;

import java.util.Objects;

import list.SinglyLinkedList.Node;

public class Q2 {
	public <T> T kToLast(SinglyLinkedList<T> list, int k) {
		Objects.requireNonNull(list);
		if (k < 0) {
			throw new IllegalArgumentException("Invalid k to last: " + k);
		}
		
		Node<T> kth = list.head();
		Node<T> end = list.head();
		
		for (int i = 0; i < k && end.next() != null; ++i) {
			end = end.next();
		}
		
		while (end.next() != null) {
			kth = kth.next();
			end = end.next();
		}
		
		return kth.data();
	}
}
