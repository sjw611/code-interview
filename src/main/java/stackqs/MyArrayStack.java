package stackqs;

public class MyArrayStack<T> implements MyStack<T> {

	private static final int DEFAULT_ARRAY_CAPACITY = 2;
	
	@SuppressWarnings("unchecked")
	private T[] array = (T[]) new Object[DEFAULT_ARRAY_CAPACITY];
	
	private int size = 0;
	
	@Override
	public T pop() {
		if (size == 0) {
			return null;
		}
		return array[--size];
	}

	@Override
	public boolean push(T element) {
		ensureCapacity();
		array[size++] = element;
		return true;
	}

	private void ensureCapacity() {
		if (size == array.length) {
			@SuppressWarnings("unchecked")
			T[] doubled = (T[]) new Object[2 * size];
			System.arraycopy(array, 0, doubled, 0, size);
			array = doubled;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			return null;
		}
		return array[size - 1];
	}

}
