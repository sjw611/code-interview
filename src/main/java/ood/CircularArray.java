package ood;

import java.util.Iterator;

public class CircularArray<T> implements Iterable<T> {

	private static final int DEFAULT_CAPACITY = 10;
	private static final int SENTINAL = -1;

	private T[] array;
	private int head = SENTINAL;
	private int tail = SENTINAL;

	public CircularArray() {
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public CircularArray(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("Capacity must be positive. Actual: " + capacity);
		}
		array = (T[]) new Object[capacity];
	}

	public int size() {
		if (head == SENTINAL && tail == SENTINAL) {
			return 0;
		}
		if (tail >= head) {
			return tail - head + 1;
		}
		return array.length - head + tail + 1;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public T add(T element) {
		if (head == SENTINAL) {
			head = 0;
		}
		T result = null;

		tail = (tail + 1) % array.length;

		if (array[tail] != null) {
			result = array[tail];
			head = (head + 1) % array.length;
		}

		array[tail] = element;

		return result;
	}

	public T removeFirst() {
		if (head == SENTINAL) {
			return null;
		}
		T result = array[head];
		array[head] = null;
		head = (head + 1) % array.length;
		return result;
	}

	public T removeLast() {
		if (tail == SENTINAL) {
			return null;
		}

		T result = array[tail];
		array[tail] = null;

		tail = (tail - 1 + array.length) % array.length;

		return result;
	}

	@Override
	public Iterator<T> iterator() {
		return new CircularArrayIterator();
	}

	private class CircularArrayIterator implements Iterator<T> {

		private int pointer = head;
		private boolean hasNextCalled = false;

		@Override
		public boolean hasNext() {
			hasNextCalled = true;

			if (isEmpty()) {
				return false;
			}

			if (head <= tail) {
				return pointer <= tail;
			}

			return !(pointer > tail && pointer < head);
		}

		@Override
		public T next() {
			if (!hasNextCalled) {
				throw new IllegalStateException("Call hasNext() first");
			}

			T result = array[pointer];

			pointer = (pointer + 1) % array.length;

			hasNextCalled = false;

			return result;
		}

	}
}
