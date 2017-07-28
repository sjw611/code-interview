package stackqs;

import list.DoublyLinkedList;

public class MyDoublyLinkedListStack<T> implements MyStack<T> {

	private DoublyLinkedList<T> list = new DoublyLinkedList<>();
	
	@Override
	public T pop() {
		return list.removeLast();
	}

	@Override
	public boolean push(T element) {
		list.add(element);
		return true;
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public T peek() {
		return list.lastElement();
	}

}
