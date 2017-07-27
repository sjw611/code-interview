package list;

import java.util.ArrayDeque;
import java.util.Deque;

import list.SinglyLinkedList.Node;

public class Q6 {
	public <T> boolean palindrome(Node<T> head) {
		Node<T> hare = head;
		Node<T> tortoise = head;
		
		Deque<T> stack = new ArrayDeque<>();
		
		while (hare != null && hare.next != null) {
			stack.push(tortoise.data);
			hare = hare.next.next;
			tortoise = tortoise.next;
		}
		
		if (hare != null) {
			tortoise = tortoise.next;
		}
		
		while (tortoise != null) {
			if (!tortoise.data.equals(stack.pop())) {
				return false;
			}
			tortoise = tortoise.next;
		}
		return true;
	}
}
