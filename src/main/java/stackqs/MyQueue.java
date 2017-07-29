package stackqs;

public interface MyQueue<T> {
	boolean enqueue(T element);

	T dequeue();

	T head();

	int size();

	default boolean isEmpty() {
		return size() == 0;
	}

}
