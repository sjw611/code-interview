package stackqs;

import list.DoublyLinkedList;

public class MinStack<T extends Comparable<? super T>> implements MyStack<T> {

	private DoublyLinkedList<T> list = new DoublyLinkedList<>();
	private DoublyLinkedList<T> min = new DoublyLinkedList<>();

	@Override
	public T pop() {
		min.removeLast();
		return list.removeLast();
	}

	@Override
	public boolean push(T element) {
		if (list.isEmpty()) {
			list.add(element);
			min.add(element);
			return true;
		}

		T currentMin = min.lastElement();
		T newMin = element.compareTo(currentMin) < 0 ? element : currentMin;

		list.add(element);
		min.add(newMin);

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

	public T min() {
		return min.lastElement();
	}

}
