package list;

import java.util.Objects;

import list.SinglyLinkedList.Node;

public class Q1 {
	public <T> void removeDuplicates(SinglyLinkedList<T> list) {
		Objects.requireNonNull(list);

		for (Node<T> i = list.head(); i != null; i = i.next()) {
			for (Node<T> j = i.next(); j != null; j = j.next()) {
				if (j.data().equals(i.data())) {
					list.delete(j.data());
				}
			}
		}
	}
}
