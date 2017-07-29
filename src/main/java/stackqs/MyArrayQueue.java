package stackqs;

public class MyArrayQueue<T> implements MyQueue<T> {

	private static final int DEFAULT_ARRAY_CAPACITY = 2;
	
	@SuppressWarnings("unchecked")
	private T[] array = (T[]) new Object[DEFAULT_ARRAY_CAPACITY];
	
	private int head;
	private int tail;
	
	@Override
	public boolean enqueue(T element) {
		array[tail++] = element;
		
		if (tail == array.length) {
			tail = 0;
		}
		
		if (tail == head) {
			ensureCapacity();
		}
		
		return true;
	}

	private void ensureCapacity() {
		@SuppressWarnings("unchecked")
		T[] doubled = (T[]) new Object[array.length * 2];
		
		System.arraycopy(array, head, doubled, 0, array.length - head);
		System.arraycopy(array, 0, doubled, array.length - head, tail);
		
		tail = array.length + tail - head;
		head = 0;
		
		array = doubled;
	}

	@Override
	public T dequeue() {
		if (isEmpty()) {
			return null;
		}
		
		T result = array[head];
		array[head++] = null;
		
		return result;
	}

	@Override
	public T head() {
		return array[head];
	}

	@Override
	public int size() {
		if (head <= tail) {
			return tail - head;
		}
		return array.length + tail - head;
	}

}
