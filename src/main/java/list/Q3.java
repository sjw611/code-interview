package list;

import java.util.Objects;

import list.SinglyLinkedList.Node;

public class Q3 {
	public <T> void deleteMiddleNode(Node<T> middleNode) {
		Objects.requireNonNull(middleNode);
		Objects.requireNonNull(middleNode.next);

		middleNode.data = middleNode.next.data;
		middleNode.next = middleNode.next.next;
	}
}
