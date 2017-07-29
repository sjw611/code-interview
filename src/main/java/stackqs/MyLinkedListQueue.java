package stackqs;

import list.DoublyLinkedList;

public class MyLinkedListQueue<T> implements MyQueue<T> {

	private DoublyLinkedList<T> list = new DoublyLinkedList<>();
	
	@Override
	public boolean enqueue(T element) {
		list.add(element);
		return true;
	}

	@Override
	public T dequeue() {
		return list.removeFirst();
	}

	@Override
	public T head() {
		return list.firstElement();
	}

	@Override
	public int size() {
		return list.size();
	}

}
