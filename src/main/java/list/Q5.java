package list;

import java.util.ArrayDeque;
import java.util.Deque;

import list.SinglyLinkedList.Node;

public class Q5 {
	public SinglyLinkedList<Integer> sum(SinglyLinkedList<Integer> l1, SinglyLinkedList<Integer> l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		
		SinglyLinkedList<Integer> result = new SinglyLinkedList<>();
		
		Node<Integer> l1Pointer = l1.head();
		Node<Integer> l2Pointer = l2.head();
		
		int carryOver = 0;
		
		while (l1Pointer != null || l2Pointer != null) {
			int l1Digit = l1Pointer == null ? 0 : l1Pointer.data;
			int l2Digit = l2Pointer == null ? 0 : l2Pointer.data;
			int sum = l1Digit + l2Digit + carryOver;
			int digit = sum % 10;
			carryOver = sum / 10;
			result.append(digit);
			
			if (l1Pointer != null) {
				l1Pointer = l1Pointer.next;
			}
			if (l2Pointer != null) {
				l2Pointer = l2Pointer.next;
			}
		}

		if (carryOver != 0) {
			result.append(carryOver);
		}
		
		return result;
	}
	
	public SinglyLinkedList<Integer> reverseSum(SinglyLinkedList<Integer> l1, SinglyLinkedList<Integer> l2) {
		return reverse(sum(reverse(l1), reverse(l2)));
	}

	private SinglyLinkedList<Integer> reverse(SinglyLinkedList<Integer> l) {
		if (l == null) {
			return l;
		}
		Deque<Integer> stack = new ArrayDeque<>();
		for (Node<Integer> current = l.head(); current != null; current = current.next) {
			stack.push(current.data);
		}
		
		SinglyLinkedList<Integer> result = new SinglyLinkedList<>();
		
		while (!stack.isEmpty()) {
			result.append(stack.pop());
		}
		
		return result;
	}
}
