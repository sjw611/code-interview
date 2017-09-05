package ood;

import java.util.Iterator;

public class CircularArray<T> implements Iterable<T> {

	private static final int DEFAULT_CAPACITY = 10;

	private T[] array;
	private int head = 0;
	private int tail = 0;

	public CircularArray() {
		this(DEFAULT_CAPACITY);
	}

	public int size() {
		return 0;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean add(T element) {
		return false;
	}

	public T removeFirst() {
		return null;
	}

	public T removeLast() {
		return null;
	}

	@SuppressWarnings("unchecked")
	public CircularArray(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("Capcity must be positive. Actual: " + capacity);
		}
		array = (T[]) new Object[capacity];
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
