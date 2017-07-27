package list;

import java.util.Objects;

import list.SinglyLinkedList.Node;

public class Q4 {
	public <T extends Comparable<? super T>> SinglyLinkedList<T> partition(SinglyLinkedList<T> list, T pivot) {
		Objects.requireNonNull(list);
		Objects.requireNonNull(pivot);
		
		SinglyLinkedList<T> left = new SinglyLinkedList<>();
		SinglyLinkedList<T> right = new SinglyLinkedList<>();
		
		for (Node<T> current = list.head(); current != null; current = current.next) {
			if (current.data.compareTo(pivot) < 0) {
				left.append(current.data);
			} else {
				right.append(current.data);
			}
		}
		
		for (Node<T> current = right.head(); current != null; current = current.next) {
			left.append(current.data);
		}
		
		return left;
	}
}
