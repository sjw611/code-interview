package stackqs;

public interface MyStack<T> {

	public T pop();
	
	public boolean push(T element);
	
	public int size();
	
	public default boolean isEmpty() {
		return size() == 0;
	}
	
	public T peek();
}
