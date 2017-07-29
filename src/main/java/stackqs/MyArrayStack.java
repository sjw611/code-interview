package stackqs;

public class MyArrayStack<T> implements MyStack<T> {

	private ArrayStacks<T> stack = new ArrayStacks<>(1);
	
	@Override
	public T pop() {
		return stack.pop(1);
	}

	@Override
	public boolean push(T element) {
		return stack.push(element, 1);
	}

	@Override
	public int size() {
		return stack.size(1);
	}

	@Override
	public T peek() {
		return stack.peek(1);
	}

}
