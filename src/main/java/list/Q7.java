package list;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import list.SinglyLinkedList.Node;

public class Q7 {
	public <T> Node<T> intersection(Node<T> l1, Node<T> l2) {
		Objects.requireNonNull(l1);
		Objects.requireNonNull(l2);

		Set<Node<T>> incomingNodes = new HashSet<>();
		
		for (Node<T> i = l1; i.next != null; i = i.next) {
			incomingNodes.add(i.next);
		}
		
		for (Node<T> i = l2; i.next != null; i = i.next) {
			if (incomingNodes.contains(i.next)) {
				return i.next;
			}
		}
		
		return null;
	}
}
